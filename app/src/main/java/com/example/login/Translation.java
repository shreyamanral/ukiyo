package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

public class Translation extends AppCompatActivity {

    private TextView srclang,outtxt;
    private EditText intxt;
    private ImageButton translateBtn;
    private String instr;
    private static final String TAG = "LangID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        srclang = (TextView) findViewById(R.id.srclang);
        outtxt = (TextView) findViewById(R.id.outtext);
        intxt = (EditText) findViewById(R.id.inptxt);
        translateBtn = (ImageButton) findViewById(R.id.translate);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                identifyLang();
            }
        });
    }

   private void identifyLang() {
        instr=intxt.getText().toString();
        FirebaseLanguageIdentification identifier = FirebaseNaturalLanguage.getInstance().getLanguageIdentification();
        identifier.identifyLanguage(instr).addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {
                if(s.equals("und")){
                    Toast.makeText(getApplicationContext(),"Language not identified!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    getLanguageCode(s);
                }
            }
        });
   }

    private void getLanguageCode(String language) {
        int langCode;
        switch (language){
            case "hi":
                langCode= FirebaseTranslateLanguage.HI;
                srclang.setText("Hindi");
                break;
            case "ar":
                langCode=FirebaseTranslateLanguage.AR;
                srclang.setText("Arabic");
                break;
            case "ja":
                langCode=FirebaseTranslateLanguage.JA;
                srclang.setText("Japanese");
                break;
            case "en":
                langCode=FirebaseTranslateLanguage.EN;
                srclang.setText("English");
                break;
            case "fr":
                langCode=FirebaseTranslateLanguage.FR;
                srclang.setText("French");
                break;
            case "it":
                langCode=FirebaseTranslateLanguage.IT;
                srclang.setText("Italian");
                break;
            case "de":
                langCode=FirebaseTranslateLanguage.DE;
                srclang.setText("German");
                //outtxt.setText(langCode);
                break;
            case "ms":
                langCode=FirebaseTranslateLanguage.MS;
                srclang.setText("Malay");
                break;
            case "es-mx":
                langCode=FirebaseTranslateLanguage.ES;
                srclang.setText("Spanish");
                break;
            case "pl":
                langCode=FirebaseTranslateLanguage.PL;
                srclang.setText("Polish");
                break;
            case "th":
                langCode= FirebaseTranslateLanguage.TH;
                srclang.setText("Thai");
                break;
            default:
                langCode=0;
        }
       translateText(langCode);
    }

   private void translateText(int langCode) {

        try {
        FirebaseTranslatorOptions opts=new FirebaseTranslatorOptions.Builder().setSourceLanguage(langCode).setTargetLanguage(FirebaseTranslateLanguage.EN).build();
        FirebaseTranslator trs=FirebaseNaturalLanguage.getInstance().getTranslator(opts);
        FirebaseModelDownloadConditions cnds= new FirebaseModelDownloadConditions.Builder().requireWifi().build();
        trs.downloadModelIfNeeded(cnds).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                trs.translate(instr).addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(@NonNull String s) {
                        outtxt.setText(s);
                    }
                });
            }
        });
        } catch (Exception e) {
            //outtxt.setText("ERROR");
            e.printStackTrace();
        }

    }
}