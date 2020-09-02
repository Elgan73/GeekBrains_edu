package com.stark.geekbrains_edu.FireBaseMessages;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.stark.geekbrains_edu.R;

public class MyFireBaseMessaging extends FirebaseMessagingService {

    final private String TAG = "WEATHER";
    private int messageID = 0;

    public MyFireBaseMessaging() {}

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, remoteMessage.getNotification().getBody());
        String title = remoteMessage.getNotification().getTitle();
        if (title == null) {
            title = "Push Message";
        }
        String text = remoteMessage.getNotification().getBody();
        createNotification(title, text);
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Token:" + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {}

    private void createNotification(String title, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "2")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text);
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(messageID++, builder.build());
    }
}
