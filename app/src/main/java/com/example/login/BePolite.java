package com.example.login;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BePolite extends choose_country{

    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    RadioGroup rgcntry;
    MediaPlayer mp;
    ImageView sp1,sp2,sp3,sp4,sp5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_polite);

        rgcntry=(RadioGroup)findViewById(R.id.rbtn);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        r5=(RadioButton)findViewById(R.id.r5);
        r6=(RadioButton)findViewById(R.id.r6);
        r7=(RadioButton)findViewById(R.id.r7);
        r8=(RadioButton)findViewById(R.id.r8);
        r9=(RadioButton)findViewById(R.id.r9);
        r10=(RadioButton)findViewById(R.id.r10);



       /*if(r3.isChecked())
        {
            bpbg.setImageDrawable(getResources().getDrawable(R.drawable.bepolite_ind));
        }*/


    }
}