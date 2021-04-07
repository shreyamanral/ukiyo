package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class Globe extends AppCompatActivity {

    ImageButton spin;
    LottieAnimationView globe;
    TextView spinstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_globe);

        spin=(ImageButton)findViewById(R.id.spinbttn);
        globe=(LottieAnimationView)findViewById(R.id.globe);
        spinstop=(TextView)findViewById(R.id.spinstop);


        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globe.setSpeed(2);
                globe.playAnimation();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent i;
                        i = new Intent(Globe.this, CountryRandom.class);
                        startActivity(i);
                    }
                },5000);
            }
        });
    }
}