package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Japan extends AppCompatActivity {

    ImageButton gobtn_jap;
    ImageView bck_jap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);

        gobtn_jap=(ImageButton)findViewById(R.id.gobtn_jap);
        bck_jap=(ImageView)findViewById(R.id.bck_jap);

        bck_jap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Japan.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_jap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Japan.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}