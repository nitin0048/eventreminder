package com.example.eventreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;

public class ReminderBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String eventTitle = intent.getStringExtra("eventTitle");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "eventReminder")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Event Reminder")
                .setContentText(eventTitle != null ? eventTitle : "It's time!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null)
            manager.notify(1, builder.build());
    }
}
