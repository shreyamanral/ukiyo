package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Italy extends AppCompatActivity {

    ImageView bck_itl;
    ImageButton gobtn_itl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italy);

        gobtn_itl=(ImageButton)findViewById(R.id.gobtn_itl);
        bck_itl=(ImageView)findViewById(R.id.bck_itl);

        bck_itl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Italy.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_itl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Italy.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}