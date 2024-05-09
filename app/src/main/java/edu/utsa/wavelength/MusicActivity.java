package edu.utsa.wavelength;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    ImageView skipButton;
    ImageView backButton;
    boolean isPlaying = false;
    MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);

        img = findViewById(R.id.playpause);
        skipButton = findViewById(R.id.skip);
        backButton = findViewById(R.id.goback);

        musicPlayer = MediaPlayer.create(this, R.raw.million);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    togglePlayPause();
                    return true; // Consume the touch event
                }
                return false;
            }
        });

        skipButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playNextSong();
                    return true; // Consume the touch event
                }
                return false;
            }
        });

        backButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playPreviousSong();
                    return true; // Consume the touch event
                }
                return false;
            }
        });
    }

    private void togglePlayPause() {
        if (isPlaying) {
            musicPlayer.pause();
            isPlaying = false;
        } else {
            musicPlayer.start();
            isPlaying = true;
        }
    }

    private void playNextSong() {
       // musicPlayer.stop();
        musicPlayer = MediaPlayer.create(this, R.raw.whatever);
        musicPlayer.start();
        isPlaying = true;
    }

    private void playPreviousSong() {
       // musicPlayer.stop();
        musicPlayer = MediaPlayer.create(this, R.raw.snooze);
        musicPlayer.start();
        isPlaying = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (musicPlayer != null) {
            musicPlayer.release();
            musicPlayer = null;
        }
    }
}