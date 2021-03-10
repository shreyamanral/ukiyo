package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class Verify extends AppCompatActivity {

    TextView tvnotver,resend,mail;
    Button signout,refresh;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    private  FirebaseAuth.AuthStateListener mAuthSListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        tvnotver=(TextView)findViewById(R.id.tvnotver);
        resend=(TextView)findViewById(R.id.tvresend);
        mail=(TextView)findViewById(R.id.tvmail);
        signout=(Button)findViewById(R.id.sngot);
        refresh=(Button)findViewById(R.id.ref);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        userID=fAuth.getCurrentUser().getUid();
        final FirebaseUser user=fAuth.getCurrentUser();

        if(!user.isEmailVerified()){
            resend.setVisibility(View.VISIBLE);
            tvnotver.setVisibility(View.VISIBLE);
            mail.setVisibility(View.VISIBLE);
            final DocumentReference docref = fStore.collection("Users").document(userID);
            docref.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    mail.setText(documentSnapshot.getString("Email"));
                }
            });
            resend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resend.setText("Resend Email");
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Verify.this,"Verification Mail Sent",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }
        else {
            resend.setVisibility(View.INVISIBLE);
            tvnotver.setVisibility(View.INVISIBLE);
        }
        if(user.isEmailVerified()) {
            Intent intent = new Intent(Verify.this, Dashboard.class);
            startActivity(intent);
        }
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Verify.this, Login.class);
                startActivity(intent);
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(user.isEmailVerified()) {
                    Intent intent = new Intent(Verify.this, Login.class);
                    startActivity(intent);
                /*}
                else
                {
                    Toast.makeText(Verify.this,"Verify the Email First!",Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }
}