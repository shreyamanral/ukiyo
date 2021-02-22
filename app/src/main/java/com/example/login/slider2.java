package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class slider2 extends AppCompatActivity {
    ImageButton tos3;
    TextView sk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider2);

        tos3=(ImageButton)findViewById(R.id.tos3);
        sk2=(TextView)findViewById(R.id.sk2);

        tos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider2.this,slider3.class);
                startActivity(i);
            }
        });

        sk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(slider2.this,LoginOptions.class);
                startActivity(i);
            }
        });
    }
}