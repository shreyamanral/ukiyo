package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class France extends AppCompatActivity {

    ImageButton gobtn_fra;
    ImageView bck_fra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_france);

        gobtn_fra=(ImageButton)findViewById(R.id.gobtn);
        bck_fra=(ImageView)findViewById(R.id.back);

        bck_fra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(France.this, choose_country.class);
                startActivity(intent);
            }
        });

        gobtn_fra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(France.this, Common_Dashboard.class);
                startActivity(intent);
            }
        });
    }
}