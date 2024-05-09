package edu.utsa.wavelength;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;
//import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    boolean isPlaying = false;
    MediaPlayer musicPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);

        img = findViewById(R.id.playpause);
        musicPlayer = MediaPlayer.create(this, R.raw.shake);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if (isPlaying) {
                        musicPlayer.pause();
                        isPlaying = false;
                    } else{
                        musicPlayer.start();
                    isPlaying = true;
                }

                return true;
            }
            return false;
            }
        });
    }
}
