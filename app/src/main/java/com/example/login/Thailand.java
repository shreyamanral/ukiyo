package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Thailand extends AppCompatActivity {

    ImageButton gobtn_tha;
    ImageView bck_tha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thailand);

        gobtn_tha=(ImageButton)findViewById(R.id.gobtn_tha);
        bck_tha=(ImageView)findViewById(R.id.bck_tha);

        bck_tha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Thailand.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_tha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Thailand.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}