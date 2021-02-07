package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Germany extends AppCompatActivity {

    ImageView bck_ger;
    ImageButton gobtn_ger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_germany);

        gobtn_ger=(ImageButton)findViewById(R.id.gobtn_ger);
        bck_ger=(ImageView)findViewById(R.id.bck_ger);

        bck_ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Germany.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Germany.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}