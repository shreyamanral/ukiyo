package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Planner extends AppCompatActivity {

    ImageButton p_to_cdsh;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        p_to_cdsh=(ImageButton)findViewById(R.id.p_to_cdsh);
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        cb5=(CheckBox)findViewById(R.id.cb5);
        cb6=(CheckBox)findViewById(R.id.cb6);
        cb7=(CheckBox)findViewById(R.id.cb7);
        cb8=(CheckBox)findViewById(R.id.cb8);
        cb9=(CheckBox)findViewById(R.id.cb9);
        cb10=(CheckBox)findViewById(R.id.cb10);


        p_to_cdsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Planner.this,Common_Dashboard.class);
                startActivity(i);
            }
        });
    }
}