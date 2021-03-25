package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Globe extends AppCompatActivity {

    ImageButton spin;
    LottieAnimationView globe;
    TextView spinstop;
    int c=0;

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
                if (c == 0) {
                    globe.playAnimation();
                    spinstop.setText("Stop");
                    c = 1;
                } else if (c == 1) {
                    globe.pauseAnimation();
                    spinstop.setText("Spin");
                    c = 0;
                }
            }
        });
    }
}