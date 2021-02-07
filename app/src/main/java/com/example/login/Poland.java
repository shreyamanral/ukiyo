package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Poland extends AppCompatActivity {

    ImageView bck_pol;
    ImageButton gobtn_pol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poland);

        gobtn_pol=(ImageButton)findViewById(R.id.gobtn_pol);
        bck_pol=(ImageView)findViewById(R.id.bck_pol);

        bck_pol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poland.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_pol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poland.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}