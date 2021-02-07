package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class choose_country extends AppCompatActivity {

    RadioGroup rgcntry;
    ImageButton cnf;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country);
        rgcntry=(RadioGroup)findViewById(R.id.rbtn);
        cnf=(ImageButton)findViewById(R.id.cnfrm);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        r5=(RadioButton)findViewById(R.id.r5);
        r6=(RadioButton)findViewById(R.id.r6);
        r7=(RadioButton)findViewById(R.id.r7);
        r8=(RadioButton)findViewById(R.id.r8);
        r9=(RadioButton)findViewById(R.id.r9);
        r10=(RadioButton)findViewById(R.id.r10);

        cnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId=rgcntry.getCheckedRadioButtonId();
                if(checkedId==-1)
                {
                    Message.message(getApplicationContext(),"No Country Selected!");
                }
                else
                {
                    findRadioButton(checkedId);
                }
            }
        });
    }

    private void findRadioButton(int chk) {
        switch (chk){
            case R.id.r1:
                Intent intent = new Intent(choose_country.this, France.class);
                startActivity(intent);
                break;
            case R.id.r2:
                Intent i = new Intent(choose_country.this, Germany.class);
                startActivity(i);
                break;
            case R.id.r3:
                Intent i3 = new Intent(choose_country.this, India.class);
                startActivity(i3);
                break;
            case R.id.r4:
                Intent i4 = new Intent(choose_country.this, Italy.class);
                startActivity(i4);
                break;
            case R.id.r5:
                Intent i5 = new Intent(choose_country.this, Japan.class);
                startActivity(i5);
                break;
            case R.id.r6:
                Intent i6 = new Intent(choose_country.this, Malaysia.class);
                startActivity(i6);
                break;
            case R.id.r7:
                Intent i7 = new Intent(choose_country.this, Mexico.class);
                startActivity(i7);
                break;
            case R.id.r8:
                Intent i8 = new Intent(choose_country.this, Poland.class);
                startActivity(i8);
                break;
            case R.id.r9:
                Intent i9 = new Intent(choose_country.this, Thailand.class);
                startActivity(i9);
                break;
            case R.id.r10:
                Intent i10 = new Intent(choose_country.this, America.class);
                startActivity(i10);
                break;
        }
    }
}