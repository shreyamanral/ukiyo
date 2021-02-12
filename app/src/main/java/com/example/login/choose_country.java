package com.example.login;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class choose_country extends AppCompatActivity {

    RadioGroup rgcntry;
    ImageButton cnf;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    NotificationManager mNotifyManager;
    String fact;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

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
                Intent i = new Intent(choose_country.this, France.class);
                startActivity(i);
                fact="In France it's legal to marry a dead person!";
                break;
            case R.id.r2:
                Intent i2 = new Intent(choose_country.this, Germany.class);
                startActivity(i2);
                fact="There are over 1,500 different beers in Germany!";
                break;
            case R.id.r3:
                Intent i3 = new Intent(choose_country.this, India.class);
                startActivity(i3);
                fact="India was the first county to mine diamonds!";
                break;
            case R.id.r4:
                Intent i4 = new Intent(choose_country.this, Italy.class);
                startActivity(i4);
                fact="The Italians have over 2,500 varieties of cheese!";
                break;
            case R.id.r5:
                Intent i5 = new Intent(choose_country.this, Japan.class);
                startActivity(i5);
                fact="In Japan, people are hired to push people inside of trains during rush hour!";
                break;
            case R.id.r6:
                Intent i6 = new Intent(choose_country.this, Malaysia.class);
                startActivity(i6);
                fact="Singapore was once a part of Malaysia!";
                break;
            case R.id.r7:
                Intent i7 = new Intent(choose_country.this, Mexico.class);
                startActivity(i7);
                fact="The meteorite that was responsible for the extinction of dinosaurs landed in Mexico!";
                break;
            case R.id.r8:
                Intent i8 = new Intent(choose_country.this, Poland.class);
                startActivity(i8);
                fact="Wearing a hat indoors is considered rude in Poland!";
                break;
            case R.id.r9:
                Intent i9 = new Intent(choose_country.this, Thailand.class);
                startActivity(i9);
                fact="Thailand has more birds than Europe and America combined!";
                break;
            case R.id.r10:
                Intent i10 = new Intent(choose_country.this, America.class);
                startActivity(i10);
                fact="There is a city named 'Boring' and it's in Oregon!";
                break;
        }
        createNotificationChannel();
        sendShareNotification(fact);
    }
    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Mascot Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }
    private void sendShareNotification(String fact){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                .setContentTitle("Did You Know?")
                .setContentText(fact)
                .setSmallIcon(R.drawable.message)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_TEXT,"My score: "+score.getText().toString());
        intent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(intent,"Share with");
        PendingIntent sharePendingIntent = PendingIntent.getActivity(this,0,shareIntent,PendingIntent.FLAG_ONE_SHOT);
        notifyBuilder.addAction(R.drawable.message, "Share", sharePendingIntent);
        mNotifyManager.notify(0, notifyBuilder.build());
    }
}