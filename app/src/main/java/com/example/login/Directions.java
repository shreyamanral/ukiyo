package com.example.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Directions extends AppCompatActivity {

    MediaPlayer mp1,mp2,mp3,mp4,mp5;
    ImageView sp1,sp2,sp3,sp4,sp5;
    ImageButton d_to_cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        sp1=(ImageView)findViewById(R.id.sd1);
        sp2=(ImageView)findViewById(R.id.sd2);
        sp3=(ImageView)findViewById(R.id.sd3);
        sp4=(ImageView)findViewById(R.id.sd4);
        sp5=(ImageView)findViewById(R.id.sd5);
        d_to_cp=(ImageButton)findViewById(R.id.d_to_cp);

        mp1= MediaPlayer.create(getApplication(),R.raw.jap_left);
        mp2=MediaPlayer.create(getApplication(),R.raw.jap_right);
        mp3=MediaPlayer.create(getApplication(),R.raw.jap_turn);
        mp4=MediaPlayer.create(getApplication(),R.raw.jap_straight);
        mp5=MediaPlayer.create(getApplication(),R.raw.jap_across);

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

        d_to_cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Directions.this,CommonPhrases.class);
                startActivity(i);
            }
        });
    }
}