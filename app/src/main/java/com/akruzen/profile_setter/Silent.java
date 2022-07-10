package com.akruzen.profile_setter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class Silent extends AppCompatActivity {

    private void setRingerMode () {
        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        Toast.makeText(this, "Phone set to silent", Toast.LENGTH_SHORT).show();
        finishAndRemoveTask();
    }

    private void getPermission () {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (!notificationManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }
    }

    private boolean permissionGranted() {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        return notificationManager.isNotificationPolicyAccessGranted();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!permissionGranted()) {
            Toast.makeText(this, "Please select Pro Set here and allow DnD permission.", Toast.LENGTH_SHORT).show();
            getPermission();
        }
        else {
            try {
                setRingerMode();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}