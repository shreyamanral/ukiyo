package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class slider3 extends AppCompatActivity {

    ImageButton tos4;
    TextView sk3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider3);

        tos4=(ImageButton)findViewById(R.id.tos4);
        sk3=(TextView)findViewById(R.id.sk3);

        tos4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider3.this,slider4.class);
                startActivity(i);
            }
        });

        sk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider3.this,LoginOptions.class);
                startActivity(i);
            }
        });
    }
}