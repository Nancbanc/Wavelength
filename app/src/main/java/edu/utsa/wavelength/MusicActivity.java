package edu.utsa.wavelength;

import android.os.Bundle;
import android.view.View;

import androidx.activity.ComponentActivity;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);

        img = findViewById(R.id.playpause);
        img.setOnTouchListener(new View.OnTouchListener() {

        }

    }
}


