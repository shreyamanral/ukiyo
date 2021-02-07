package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Malaysia extends AppCompatActivity {

    ImageView bck_mal;
    ImageButton gobtn_mal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaysia);

        gobtn_mal=(ImageButton)findViewById(R.id.gobtn_mal);
        bck_mal=(ImageView)findViewById(R.id.bck_mal);

        bck_mal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malaysia.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_mal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malaysia.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}