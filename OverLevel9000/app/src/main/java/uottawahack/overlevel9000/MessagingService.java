package uottawahack.overlevel9000;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2018-02-17.
 */

public class MessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private static final String LOCATION = "file:///android_assets/time.txt";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "FROM:" + remoteMessage.getFrom());

        // Check if message has data
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data: " + remoteMessage.getData());
        }

        // Check if message contains notifications
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message body:" + remoteMessage.getNotification());

            Intent in = new Intent(this, TimeActivity.class);
            in.putExtra("value", remoteMessage.getNotification().getBody());
            startActivity(in);
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String body) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);



        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        // Set sound of notification
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Wait Time")
                .setContentText(body + " min")
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notifBuilder.build());
    }



}
