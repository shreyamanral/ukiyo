package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class America extends AppCompatActivity {

    ImageView bck_ame;
    ImageButton gobtn_ame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_america);

        gobtn_ame=(ImageButton)findViewById(R.id.gbtn);
        bck_ame=(ImageView)findViewById(R.id.bck);

        bck_ame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(America.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_ame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(America.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}