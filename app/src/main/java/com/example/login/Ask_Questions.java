package com.example.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ask_Questions extends AppCompatActivity {

    MediaPlayer mp1,mp2,mp3,mp4,mp5;
    ImageView sp1,sp2,sp3,sp4,sp5;
    ImageButton aq_to_cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask__questions);

        sp1=(ImageView)findViewById(R.id.sa1);
        sp2=(ImageView)findViewById(R.id.sa2);
        sp3=(ImageView)findViewById(R.id.sa3);
        sp4=(ImageView)findViewById(R.id.sa4);
        sp5=(ImageView)findViewById(R.id.sa5);
        aq_to_cp=(ImageButton)findViewById(R.id.aq_to_cp);

        mp1= MediaPlayer.create(getApplication(),R.raw.itl_where_is);
        mp2=MediaPlayer.create(getApplication(),R.raw.itl_how);
        mp3=MediaPlayer.create(getApplication(),R.raw.itl_who);
        mp4=MediaPlayer.create(getApplication(),R.raw.itl_when);
        mp5=MediaPlayer.create(getApplication(),R.raw.itl_what);

        sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.start();
            }
        });

        sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.start();
            }
        });

        sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });

        sp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp4.start();
            }
        });

        sp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp5.start();
            }
        });

        aq_to_cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ask_Questions.this,CommonPhrases.class);
                startActivity(i);
            }
        });
    }
}