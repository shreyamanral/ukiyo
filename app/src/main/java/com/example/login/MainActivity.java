package com.example.login;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern PASS_PAT =
            Pattern.compile("^"+
                    "(?=.*[0-9])"+
                    "(?=.*[a-z])"+
                    "(?=.*[A-Z])"+
                    "(?=.*[@#$%^&+=])"+
                    ".{8,15}" +
                    "$");

    private static final Pattern phone_PAT = Pattern.compile("^[0-9\\s]*$");

    private static final Pattern name_PAT = Pattern.compile("^[a-zA-Z\\s]*$");

    private static final Pattern uname_PAT = Pattern.compile("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");

    int err=0;
    
    EditText name, email, pass, usname, phnno;
    ImageButton btn;
    TextView loginpage;
    DatePickerDialog picker;
    private static final String TAG = "MyActivity";
    FirebaseAuth fAuth;
    private FirebaseFirestore fstore;
    Calendar cldr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        usname=(EditText)findViewById(R.id.uname);
        phnno=(EditText)findViewById(R.id.phone);
        pass=(EditText)findViewById(R.id.password);
        btn=(ImageButton)findViewById(R.id.signup);
        loginpage=(TextView)findViewById(R.id.gotologin);



        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        if(fAuth.getCurrentUser() !=null)
        {
            Intent intent = new Intent(MainActivity.this, Verify.class);
            startActivity(intent);
            finish();
        }

        //datepicker
        /*dob.setInputType(InputType.TYPE_NULL);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, year, month, day);
                picker.show();
            }
        });*/

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String sname=name.getText().toString();
                    if(sname.trim().equals("")){
                        name.setError("Empty!!");
                    }
                    else if(!name_PAT.matcher(sname).matches())
                    {
                        name.setError("Incorrect Name!");
                    }
                }
            }
        });

        usname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    String uname= usname.getText().toString();
                    if(uname.trim().equals("")){
                        usname.setError("Empty!!");
                    }
                    else if(!uname_PAT.matcher(uname).matches())
                    {
                        usname.setError("Incorrect Username!");
                    }
                }
            }
        });

        phnno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String sphnno=phnno.getText().toString();
                    if(sphnno.isEmpty())
                    {
                        phnno.setError("Empty!!");
                    }
                    else if(!phone_PAT.matcher(sphnno).matches())
                    {
                        phnno.setError("Incorrect Phone Number!");
                    }
                    else if(phnno.length()!=10){
                        phnno.setError("Incorrect Length for Phone Number!");
                    }
                }
            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String semail=email.getText().toString();
                    if(semail.isEmpty())
                    {
                        email.setError("Empty!!");
                    }
                    else if(!Patterns.EMAIL_ADDRESS.matcher(semail).matches())
                    {
                        email.setError("Incorrect Email!");
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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String spass=pass.getText().toString();
                final String semail=email.getText().toString();
                final String sname=name.getText().toString();
                final String sphone=phnno.getText().toString();
                final String uname=usname.getText().toString();
                if(sname.trim().equals("")){
                    name.setError("Name cannot be empty!");
                    err++;
                }
                if(uname.trim().equals("")){
                    usname.setError("Name cannot be empty!");
                    err++;
                }
                if(semail.isEmpty())
                {
                    email.setError("Empty!!");
                    err++;
                }
                if(spass.isEmpty())
                {
                    pass.setError("Password Cannot Be Empty!");
                    err++;
                }
                if(sphone.isEmpty())
                {
                    phnno.setError("Phone Number Cannot Be Empty!");
                    err++;
                }
                if(err==0)
                {
                    fAuth.createUserWithEmailAndPassword(semail,spass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                FirebaseUser fuser=fAuth.getCurrentUser();

                                //add data in the cloud
                                String UserID =fAuth.getCurrentUser().getUid();
                                DocumentReference docref=fstore.collection("Users").document(UserID);
                                Map<String,Object> data =new HashMap<>();
                                data.put("Email",semail);
                                data.put("Username",uname);
                                data.put("Password",spass);
                                data.put("Name",sname);
                                data.put("Phone",sphone);
                                docref.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG,"Doc saved");
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG,"Not saved");
                                    }
                                });
                                Toast.makeText(MainActivity.this,"Sign Up Successful",Toast.LENGTH_LONG).show();
                                Intent i=new Intent(MainActivity.this, Verify.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this,"Sign Up Not Successful"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}