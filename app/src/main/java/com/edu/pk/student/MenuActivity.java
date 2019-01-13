package com.edu.pk.student;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.PasswordChangeActivity;
import com.edu.pk.R;
import com.edu.pk.student.dormitory.MenuDormitoryActivity;
import com.edu.pk.student.finance.MenuFinanceActivity;
import com.edu.pk.student.mydata.MyDataActivity;
import com.edu.pk.student.timetable.GradesActivity;
import com.edu.pk.student.timetable.MenuTimetableActivity;

public class MenuActivity extends BaseActivity {

    private static final String CHANNEL_ID = "channel_id_10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.my_data:
                intent = new Intent(MenuActivity.this, MyDataActivity.class);
                startActivity(intent);
                break;
            case R.id.my_plan:
                intent = new Intent(MenuActivity.this, MenuTimetableActivity.class);
                startActivity(intent);
                break;
            case R.id.my_finances:
                intent = new Intent(MenuActivity.this, MenuFinanceActivity.class);
                startActivity(intent);
                break;
            case R.id.my_dorms:
                intent = new Intent(MenuActivity.this, MenuDormitoryActivity.class);
                startActivity(intent);
                break;
            case R.id.change_password:
                Bundle bundle = new Bundle();
                bundle.putString("goto", "MenuActivity");
                intent = new Intent(getApplicationContext(), PasswordChangeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }


    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "name";
            String description = "description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, GradesActivity.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("text")
                .setContentText("content")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(resultPendingIntent);


        createNotificationChannel();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(0, mBuilder.build());
    }
}
