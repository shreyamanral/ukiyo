package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class India extends AppCompatActivity {

    ImageButton gobtn_ind;
    ImageView bck_ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);

        gobtn_ind=(ImageButton)findViewById(R.id.gobtn_ind);
        bck_ind=(ImageView)findViewById(R.id.bck_ind);

        bck_ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(India.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_ind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(India.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}