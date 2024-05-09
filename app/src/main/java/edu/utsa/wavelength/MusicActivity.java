package edu.utsa.wavelength;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    ImageView skipButton;
    ImageView backButton;
    boolean isPlaying = false;
    MediaPlayer musicPlayer;
    private int currentSongIndex = 0;
    int[] songCovers = {R.drawable.md, R.drawable.snooze, R.drawable.whatevershewants};
    int[] songResources = {R.raw.million, R.raw.whatever, R.raw.snooze};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);
        setupButtons();

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
<<<<<<< Updated upstream
       // musicPlayer.stop();
        musicPlayer = MediaPlayer.create(this, R.raw.whatever);
=======
        currentSongIndex = (currentSongIndex + 1) % songCovers.length;
        musicPlayer.stop();
        musicPlayer = MediaPlayer.create(this, getSongResource(currentSongIndex));
        //musicPlayer = MediaPlayer.create(this, R.raw.whatever);
>>>>>>> Stashed changes
        musicPlayer.start();

        updateSongCover();

        isPlaying = true;
    }

    private void updateSongCover(){
        int currentIndex = getCurrentSongIndex();
        img.setImageResource(songCovers[currentIndex]);
    }
    private int getCurrentSongIndex(){
        return currentSongIndex;
    }

    private void playPreviousSong() {
<<<<<<< Updated upstream
       // musicPlayer.stop();
        musicPlayer = MediaPlayer.create(this, R.raw.snooze);
=======
        currentSongIndex = (currentSongIndex - 1 + songCovers.length) % songCovers.length;
        musicPlayer.stop();
        musicPlayer = MediaPlayer.create(this, getSongResource(currentSongIndex));
>>>>>>> Stashed changes
        musicPlayer.start();
        updateSongCover();
        isPlaying = true;
    }

    private int getSongResource(int index){
        return songResources[index];
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (musicPlayer != null) {
            musicPlayer.release();
            musicPlayer = null;
        }
    }

    private void setupButtons() {

        ImageButton button1 = (ImageButton) findViewById(R.id.musichome);
        ImageButton button2 = (ImageButton) findViewById(R.id.playlist);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this, PlaylistManagement.class);
                startActivity(intent);
            }
        });
    }
}