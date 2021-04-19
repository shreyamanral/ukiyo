package com.example.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BePolite extends choose_country{

    /*RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    RadioGroup rgcntry;*/
    MediaPlayer mp1,mp2,mp3,mp4,mp5;
    ImageView sp1,sp2,sp3,sp4,sp5;
    ImageButton gotocsdh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_polite);

        /*rgcntry=(RadioGroup)findViewById(R.id.rbtn);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        r5=(RadioButton)findViewById(R.id.r5);
        r6=(RadioButton)findViewById(R.id.r6);
        r7=(RadioButton)findViewById(R.id.r7);
        r8=(RadioButton)findViewById(R.id.r8);
        r9=(RadioButton)findViewById(R.id.r9);
        r10=(RadioButton)findViewById(R.id.r10);*/

        sp1=(ImageView)findViewById(R.id.sp1);
        sp2=(ImageView)findViewById(R.id.sp2);
        sp3=(ImageView)findViewById(R.id.sp3);
        sp4=(ImageView)findViewById(R.id.sp4);
        sp5=(ImageView)findViewById(R.id.sp5);
        gotocsdh=(ImageButton)findViewById(R.id.bck_cdsh);

        mp1=MediaPlayer.create(getApplication(),R.raw.itl_please);
        mp2=MediaPlayer.create(getApplication(),R.raw.itl_thankyou);
        mp3=MediaPlayer.create(getApplication(),R.raw.itl_yes);
        mp4=MediaPlayer.create(getApplication(),R.raw.itl_no);
        mp5=MediaPlayer.create(getApplication(),R.raw.itl_sorry);

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

        gotocsdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BePolite.this,CommonPhrases.class);
                startActivity(i);
            }
        });
       /*if(r3.isChecked())
        {
            bpbg.setImageDrawable(getResources().getDrawable(R.drawable.bepolite_ind));
        }*/


    }
}