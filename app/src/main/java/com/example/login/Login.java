package com.example.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity{

    EditText email, pass;
    TextView sn,fp;
    ImageButton b1;
    FirebaseAuth fAuth;
    SignInButton signInButton;

    private FirebaseAuth.AuthStateListener nAuthSListner;

    private static final Pattern PASS_PAT =
            Pattern.compile("^"+
                    "(?=.*[0-9])"+
                    "(?=.*[a-z])"+
                    "(?=.*[A-Z])"+
                    "(?=.*[@#$%^&+=])"+
                    ".{4,15}" +
                    "$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        b1=(ImageButton)findViewById(R.id.signup);
        sn=(TextView)findViewById(R.id.gotosignup);
        fp=(TextView)findViewById(R.id.frgtpass);

        //signInButton=(SignInButton)findViewById(R.id.gsignin);



        fAuth=FirebaseAuth.getInstance();

        nAuthSListner= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = fAuth.getCurrentUser();
                if( mFirebaseUser != null){
                    //Toast.makeText(MainActivity.this,"Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Dashboard.class);
                    startActivity(intent);
                }
            }
        };

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String mail=email.getText().toString();
                    if(mail.isEmpty())
                    {
                        email.setError("Empty!!");
                    }
                    else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                    {
                        email.setError("Incorrect Email ID!");
                        email.setText("");
                    }
                    else {
                        email.setError(null);
                    }
                }
            }
        });

        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String spass=pass.getText().toString();
                    if(spass.isEmpty())
                    {
                        pass.setError("Password Cannot Be Empty!");
                    }
                    else if(!PASS_PAT.matcher(spass).matches())
                    {
                        pass.setError("Incorrect Password!");
                    }
                }
            }
        });

        sn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=email.getText().toString();
                String p=pass.getText().toString();

                if(mail.isEmpty())
                {
                    email.setError("Mail Cannot be Empty!");
                }
                else if(p.isEmpty())
                {
                    pass.setError("Password can't be empty!");
                }
                else {
                    fAuth.signInWithEmailAndPassword(mail, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, " Login Successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Login.this, Verify.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Login.this, "Sign In Not Successful" + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });

        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetmail=new EditText(v.getContext());
                AlertDialog.Builder passresetdialog=new AlertDialog.Builder(v.getContext());
                passresetdialog.setTitle("Reset Password ? ");
                passresetdialog.setMessage("Enter Your Email ");
                passresetdialog.setView(resetmail);


                passresetdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //send reset mail
                        String mail=resetmail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this,"Reset Password Link Sent",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this,"Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passresetdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close
                    }
                });

                passresetdialog.create().show();
            }
        });

        /*signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),LoginGoogle.class);
                startActivity(i);
            }
        });*/
    }

    /*switch (v.getId()){
                    case R.id.gsignin:
                        signIn();
                        break;
                        }*/
    /*private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*/

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
                Intent intent = new Intent(Login.this, Dashboard.class);
                startActivity(intent);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account= completedTask.getResult(ApiException.class);
            Intent intent = new Intent(Login.this, Dashboard.class);
            startActivity(intent);
        } catch (ApiException e) {
            Log.w(TAG, "Google sign in failed"+ e.getStatusCode());
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        fAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = fAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }

                        // ...
                    }
                });
    }*/

    protected  void onStart() {
        super.onStart();
        fAuth.addAuthStateListener(nAuthSListner);
    }

   /* @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/
}