package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Mexico extends AppCompatActivity {

    ImageButton gobtn_mex;
    ImageView bck_mex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexico);

        gobtn_mex=(ImageButton)findViewById(R.id.gobtn_mex);
        bck_mex=(ImageView)findViewById(R.id.bck_mex);

        bck_mex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mexico.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_mex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mexico.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}