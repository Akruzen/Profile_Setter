package com.akruzen.profile_setter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

public class RingerMode extends AppCompatActivity {

    private void setRingerMode () {
        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        audioManager.setStreamVolume(AudioManager.STREAM_RING, audioManager.getStreamMaxVolume(AudioManager.STREAM_RING), 0);
        Toast.makeText(this, "Maxed out the ringer volume", Toast.LENGTH_SHORT).show();
        finishAndRemoveTask();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setRingerMode();
    }
}