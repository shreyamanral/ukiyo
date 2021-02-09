package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Planner extends AppCompatActivity {

    ImageButton p_to_cdsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        p_to_cdsh=(ImageButton)findViewById(R.id.p_to_cdsh);

        p_to_cdsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Planner.this,Common_Dashboard.class);
                startActivity(i);
            }
        });
    }
}