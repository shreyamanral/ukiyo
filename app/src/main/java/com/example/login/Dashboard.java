package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Dashboard extends AppCompatActivity {

    private FirebaseFirestore fstore;
    private static final String FIRE_LOG="Firelog";

    //GoogleSignInClient mGoogleSignInClient;

    FirebaseAuth fAuth;
    ImageView trahel;
    TextView name;
    ImageView gotoexp,gotothl,gotospin,gotoprf,signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        FirebaseAuth.AuthStateListener mAuthSListner;

        trahel=(ImageView)findViewById(R.id.th);
        signout=(ImageView) findViewById(R.id.signout_icn);
        gotothl=(ImageView) findViewById(R.id.thl);
        name=(TextView)findViewById(R.id.name);


        /*GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);*/

        fAuth = FirebaseAuth.getInstance();
        fstore= FirebaseFirestore.getInstance();
        String UserID =fAuth.getCurrentUser().getUid();

        trahel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, choose_country.class);
                startActivity(intent);
            }
        });

        final DocumentReference docref = fstore.collection("Users").document(UserID);
        docref.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                name.setText(documentSnapshot.getString("Name"));
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*switch (v.getId()) {
                    // ...
                    case R.id.signout:
                        signOut();
                        FirebaseAuth.getInstance().signOut();
                        break;
                    // ...
                }*/
                if(FirebaseAuth.getInstance().getCurrentUser()!=null) {
                    FirebaseAuth.getInstance().signOut();
                    //mGoogleSignInClient.signOut();
                    Intent i= new Intent(Dashboard.this, Login.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "No user signed in", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(Dashboard.this, Login.class);
                    startActivity(i);
                }

            }
        });

       /*GoogleSignInAccount acct= GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null)
        {
            String personName=acct.getDisplayName();
            String personEmail=acct.getEmail();
            String personID=acct.getId();
            Uri personPhoto=acct.getPhotoUrl();

            name.setText(personName);
            Glide.with(this).load(String.valueOf(personPhoto)).into(img);
        }

        fstore.collection("Users").document("one").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){

                    DocumentSnapshot documentSnapshot=task.getResult();
                    String uname=documentSnapshot.getString("Name");
                    name.setText(uname);

                }
                else
                {
                    Log.d(FIRE_LOG,"Error:"+task.getException().getMessage());
                }
            }
        });*/


    }
    /*private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Dashboard.this,"Signed Out!",Toast.LENGTH_LONG).show();
                        finish();
                        Intent i= new Intent(Dashboard.this, Login.class);
                        startActivity(i);

                    }
                });
    }*/
}