package com.example.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.util.ArrayList;
import java.util.Locale;

public class Translation extends AppCompatActivity {

    TextView srclang,outtxt;
    EditText intxt;
    ImageButton translateBtn,speak;
    ImageView t_to_th;
    Translator englishGermanTranslator;
    String instr;
    private static final String TAG = "LangID";
    private final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        srclang = (TextView) findViewById(R.id.srclang);
        outtxt = (TextView) findViewById(R.id.outtext);
        intxt = (EditText) findViewById(R.id.inptxt);
        speak = (ImageButton) findViewById(R.id.voc);
        translateBtn = (ImageButton) findViewById(R.id.translate);
        t_to_th=(ImageView)findViewById(R.id.t_to_th);

        TranslatorOptions options =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.GERMAN)
                        .setTargetLanguage(TranslateLanguage.ENGLISH)
                        .build();
        englishGermanTranslator = com.google.mlkit.nl.translate.Translation.getClient(options);
        getLifecycle().addObserver(englishGermanTranslator);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkmodel();
            }
        });

        t_to_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Translation.this,Common_Dashboard.class);
                startActivity(i);
            }
        });
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Need to speak");
                try {
                    startActivityForResult(intent, REQ_CODE);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Sorry your device not supported", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    intxt.setText(result.get(0));
                }
                break;
            }
        }
    }

    private void checkmodel() {
        DownloadConditions conditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();
        englishGermanTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        translate(intxt.getText().toString());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Model couldn’t be downloaded or other internal error.
                        // ...
                        outtxt.setText("Model Not Downloaded");
                    }
                });
    }

    private void translate(String instr) {
        englishGermanTranslator.translate(instr)
                .addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(@NonNull String s) {
                        srclang.setText("German");
                        outtxt.setText(s);
                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Error.
                                // ...
                                outtxt.setText("Not Translated");
                            }
                        });
    }

   /*private void identifyLang() {
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

    }*/
}