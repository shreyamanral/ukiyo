package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class slider1 extends AppCompatActivity {

    ImageButton tos2;
    TextView sk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider1);

        tos2=(ImageButton)findViewById(R.id.tos2);
        sk1=(TextView)findViewById(R.id.sk1);

        tos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider1.this,slider2.class);
                startActivity(i);
            }
        });

        sk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider1.this,Login.class);
                startActivity(i);
            }
        });
    }
}