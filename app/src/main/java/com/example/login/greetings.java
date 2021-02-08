package com.example.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class greetings extends AppCompatActivity {

    MediaPlayer mp1,mp2,mp3,mp4,mp5;
    ImageView sp1,sp2,sp3,sp4,sp5;
    ImageButton g_to_cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        sp1=(ImageView)findViewById(R.id.sg1);
        sp2=(ImageView)findViewById(R.id.sg2);
        sp3=(ImageView)findViewById(R.id.sg3);
        sp4=(ImageView)findViewById(R.id.sg4);
        sp5=(ImageView)findViewById(R.id.sg5);
        g_to_cp=(ImageButton)findViewById(R.id.g_to_cp);

        mp1= MediaPlayer.create(getApplication(),R.raw.jap_hello);
        mp2=MediaPlayer.create(getApplication(),R.raw.jap_howru);
        mp3=MediaPlayer.create(getApplication(),R.raw.jap_cu);
        mp4=MediaPlayer.create(getApplication(),R.raw.jap_gn);
        mp5=MediaPlayer.create(getApplication(),R.raw.jap_gm);

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

        g_to_cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(greetings.this,CommonPhrases.class);
                startActivity(i);
            }
        });
    }
}