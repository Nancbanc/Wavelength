package edu.utsa.wavelength;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);

        img = findViewById(R.id.playpause);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(MusicActivity.this, R.raw.shake);
                mp.start();

                return false;
            }
        });
    }
}
