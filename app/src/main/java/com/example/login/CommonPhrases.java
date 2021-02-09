package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CommonPhrases extends AppCompatActivity {

    ImageView bepolite,greeting,direc,askq,bcktocd,bcktodash,bcktoth,sgnout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_phrases);

        bepolite=(ImageView)findViewById(R.id.bepolite);
        greeting=(ImageView)findViewById(R.id.greet);
        askq=(ImageView)findViewById(R.id.askques);
        direc=(ImageView)findViewById(R.id.direc);
        bcktocd=(ImageView)findViewById(R.id.bckBtnCphrs);
        bcktodash=(ImageView)findViewById(R.id.dshbrd);
        bcktoth=(ImageView)findViewById(R.id.thl);
        sgnout=(ImageView)findViewById(R.id.signout_icn);

        bepolite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,BePolite.class);
                startActivity(i);
            }
        });

        greeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,greetings.class);
                startActivity(i);
            }
        });

        askq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,Ask_Questions.class);
                startActivity(i);
            }
        });

        direc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,Directions.class);
                startActivity(i);
            }
        });

        bcktocd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,Common_Dashboard.class);
                startActivity(i);
            }
        });
        bcktodash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,Dashboard.class);
                startActivity(i);
            }
        });

        bcktoth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CommonPhrases.this,Common_Dashboard.class);
                startActivity(i);
            }
        });
    }
}