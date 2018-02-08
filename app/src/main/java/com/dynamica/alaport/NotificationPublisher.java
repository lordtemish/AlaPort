package com.dynamica.alaport;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Random;

/**
 * Created by 17-n008ur on 19.09.2017.
 */

public class NotificationPublisher extends BroadcastReceiver{

    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";

    public void onReceive(Context context, Intent intent) {
   //     mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
     //   Notification notifyDetails = new Notification(R.drawable.android,"Time Reset!",System.currentTimeMillis());
       // PendingIntent myIntent = PendingIntent.getActivity(context, 0, new Intent(context, Second.class), 0);



        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = intent.getParcelableExtra(NOTIFICATION);
        PendingIntent myIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);
        int id = intent.getIntExtra(NOTIFICATION_ID,(new Random()).nextInt(1000));
        notificationManager.notify(id, notification);
        Log.d("ID of Not",id+" ");

    }
}