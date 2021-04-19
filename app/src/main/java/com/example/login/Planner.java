package com.example.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Planner extends AppCompatActivity {

    ImageButton p_to_cdsh,additm;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20;
    int x=10;
    List<String> listitms=new ArrayList<>();
    FirebaseAuth fAuth;
    private FirebaseFirestore fstore;
    String TAG="Item Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        p_to_cdsh=(ImageButton)findViewById(R.id.p_to_cdsh);
        additm=(ImageButton)findViewById(R.id.add_itm);

        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        cb5=(CheckBox)findViewById(R.id.cb5);
        cb6=(CheckBox)findViewById(R.id.cb6);
        cb7=(CheckBox)findViewById(R.id.cb7);
        cb8=(CheckBox)findViewById(R.id.cb8);
        cb9=(CheckBox)findViewById(R.id.cb9);
        cb10=(CheckBox)findViewById(R.id.cb10);
        cb11=(CheckBox)findViewById(R.id.cb11);
        cb12=(CheckBox)findViewById(R.id.cb12);
        cb13=(CheckBox)findViewById(R.id.cb13);
        cb14=(CheckBox)findViewById(R.id.cb14);
        cb15=(CheckBox)findViewById(R.id.cb15);
        cb16=(CheckBox)findViewById(R.id.cb16);
        cb17=(CheckBox)findViewById(R.id.cb17);
        cb18=(CheckBox)findViewById(R.id.cb18);
        cb19=(CheckBox)findViewById(R.id.cb19);
        cb20=(CheckBox)findViewById(R.id.cb20);

        fstore=FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        CheckBox cbarray[]={cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20};

        p_to_cdsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Planner.this,Common_Dashboard.class);
                startActivity(i);
            }
        });

        //docref, fetch already added items, after additm

        additm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newitm=new EditText(v.getContext());
                AlertDialog.Builder passresetdialog=new AlertDialog.Builder(v.getContext());
                passresetdialog.setTitle("New Item ");
                passresetdialog.setMessage("Enter New Item Name");
                passresetdialog.setView(newitm);

                passresetdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //send reset mail
                        String str1=newitm.getText().toString();
                        Toast.makeText(Planner.this,str1,Toast.LENGTH_SHORT).show();

                        cbarray[x].setText(str1);
                        cbarray[x].setVisibility(View.VISIBLE);

                        //docref, add to database, items
                        String UserID =fAuth.getCurrentUser().getUid();
                        DocumentReference docref=fstore.collection("Users").document(UserID).collection("Planner_Items").document();
                        Map<String,Object> data =new HashMap<>();
                        data.put("items",str1);
                        docref.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG,"Item Added");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG,"Item Not Added");
                            }
                        });
                        x++;
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
    }
    public void checkedboxes(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.cb1:
                if (checked) {
                    listitms.add(cb1.getText().toString());
                }
                break;
            case R.id.cb2:
                if (checked) {
                    listitms.add(cb2.getText().toString());
                }
                break;
            case R.id.cb3:
                if (checked) {
                    listitms.add(cb3.getText().toString());
                }
                break;
            case R.id.cb4:
                if (checked) {
                    listitms.add(cb4.getText().toString());
                }
                break;
        }
        Log.e("Item List ", String.valueOf(listitms));
        Toast.makeText(Planner.this,String.valueOf(listitms),Toast.LENGTH_SHORT).show();
    }
}