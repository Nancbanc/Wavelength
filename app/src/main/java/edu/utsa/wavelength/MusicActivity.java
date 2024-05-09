package edu.utsa.wavelength;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);

        img = findViewById(R.id.playpause);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(MusicActivity.this, R.raw.shake);
                mp.start();

                //return false;
            }
        });
    }
}
