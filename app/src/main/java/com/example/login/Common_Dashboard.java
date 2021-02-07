package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Common_Dashboard extends AppCompatActivity {

    ImageView tran,gotocmnphrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common__dashboard);

        tran=(ImageView)findViewById(R.id.translation);
        gotocmnphrs=(ImageView)findViewById(R.id.phrs);

        tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Common_Dashboard.this,Translation.class);
                startActivity(i);
            }
        });

        gotocmnphrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Common_Dashboard.this,CommonPhrases.class);
                startActivity(i);
            }
        });
    }
}