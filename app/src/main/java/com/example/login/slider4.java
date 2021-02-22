package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class slider4 extends AppCompatActivity {

    ImageButton tolog;
    TextView sk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider4);

        tolog=(ImageButton)findViewById(R.id.tolog);
        sk4=(TextView)findViewById(R.id.sk4);

        tolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider4.this,LoginOptions.class);
                startActivity(i);
            }
        });

        sk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider4.this, LoginOptions.class);
                startActivity(i);
            }
        });
    }
}