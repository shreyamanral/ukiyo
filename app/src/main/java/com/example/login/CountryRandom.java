package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CountryRandom extends AppCompatActivity {

    TextView tv1,tv2;
    ImageView im1;
    FirebaseAuth fAuth;
    FirebaseFirestore db;
    Map<String,Object> object=null;
    Map<String,Object> object2=null;
    Map<String,Object> descobj=null;
    String dectr,descstr;
    int lind,cind,c;
    List<String> list;
    private FirebaseAuth.AuthStateListener nAuthSListner;
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_random);

        tv1 = (TextView) findViewById(R.id.cnty);
        tv2 = (TextView) findViewById(R.id.descp);

        im1 = (ImageView) findViewById(R.id.cntyimg);

        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        /*DocumentReference docRef = db.collection("Countries").document();
        docRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot document = task.getResult();
                    List<DocumentSnapshot> list=document.getDocuments();
                    Log.e("List Size", String.valueOf(list.size()));
                    for(int i=0; i<list.size();i++){
                        DocumentSnapshot doc=list.get(i);
                    }

                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });*/


        /*db.collection("Countries").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot document = task.getResult();
                    //Retriving data
                    List<DocumentSnapshot> list=document.getDocuments();
                    Log.e("List ", String.valueOf(list));
                    Log.e("List Size", String.valueOf(list.size()));

                    //Get Random index
                    Random rand=new Random();
                    int x=rand.nextInt(list.size());
                    Log.e("Selected Random Number ", String.valueOf(x));

                    //Display from List
                    object=list.get(x).getData();
                    Log.e("Selected Country: ", String.valueOf(object));

                    //Extracting Country Name
                    int k=object.toString().indexOf('=');
                    String str = object.toString().substring(1,k);
                    Log.e("String str ",str);
                    if(str.equals("image_link")){
                        lind=object.toString().lastIndexOf("=");
                        descstr=object.toString().substring(0,lind);
                        cind=descstr.lastIndexOf(",");
                        dectr=descstr.substring(cind+1,lind);
                        Log.e("Country Name ",dectr);
                    }
                    *//*String a=object.get(descstr.substring(cind+1,lind)).toString();
                    Log.e("String a ",a);*//*
                    for (Map.Entry<String, Object> entry : object.entrySet()) {
                        object2 = (Map<String, Object>) entry.getValue();
                        descobj = (Map<String, Object>) object2.get(dectr);
                        Log.e("String a ", String.valueOf(descobj));
                    }

                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });*/

        db.collection("Countries").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    list = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        list.add(document.getId());
                    }
                    Log.d(TAG, list.toString());

                    Random rand=new Random();
                    c=rand.nextInt(list.size());
                    //Log.d("Random ",list.get(c));

                    countrydoc(c, list.get(c));



                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

    }

    public void countrydoc(int i,String s){

        Log.d("Random ",s);
        DocumentReference docref;
        docref=db.collection("Countries").document(s);
        docref.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                tv1.setText(s);
                tv2.setText(documentSnapshot.getString(s));
                String x=documentSnapshot.getString("image_link");
                if(x!=null) {

                    Glide.with(getApplicationContext())
                            .load(x)
                            .into(im1);
                }
                else{
                    Toast.makeText(CountryRandom.this,"Image not found!",Toast.LENGTH_SHORT).show();
                }
            }});
    }


}

