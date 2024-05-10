package edu.utsa.wavelength;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.activity.ComponentActivity;

import java.util.Random;

public class MusicActivity extends ComponentActivity {

    ImageView img;
    ImageView skipButton;
    ImageView backButton;
    ImageView songimage;
    boolean isPlaying = false;
    MediaPlayer musicPlayer;
    SeekBar seekBar;

    Random random = new Random();
    int currentSongIndex = 0;
    int[] songCovers = {R.drawable.nlm, R.drawable.loveme, R.drawable.fyb, R.drawable.idgaf, R.drawable.md, R.drawable.snooze, R.drawable.gis, R.drawable.wannabe, R.drawable.whatevershewants};
    int[] songResources = {R.raw.neverlooseme, R.raw.loveme, R.raw.fyb, R.raw.idgaf, R.raw.million, R.raw.snooze, R.raw.gis, R.raw.wannabe, R.raw.whateversewants};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);
        setupButtons();

        img = findViewById(R.id.playpause);
        skipButton = findViewById(R.id.skip);
        backButton = findViewById(R.id.goback);
        songimage = findViewById(R.id.songplayer);
        seekBar = findViewById(R.id.seekBar);

        musicPlayer = MediaPlayer.create(this, getSongResource(currentSongIndex));
        updateSongCover();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    musicPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        musicPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mp.getDuration());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (musicPlayer != null) {
                            try {
                                int currentPosition = musicPlayer.getCurrentPosition();
                                seekBar.setProgress(currentPosition);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause();
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextSong();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPreviousSong();
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
        skipButton.setEnabled(false);
        currentSongIndex = (currentSongIndex + 1) % songCovers.length;
        if (musicPlayer.isPlaying()) {
            musicPlayer.stop();
        }
        if(musicPlayer != null){
            musicPlayer.release();
        }
        musicPlayer = MediaPlayer.create(this, getSongResource(currentSongIndex));
        // another setOnPreparedListner so when the skip button is pressed, it doesn't quit
        musicPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                skipButton.setEnabled(true);
            }
        });
        updateSongCover();
        isPlaying = true;
    }

    private void updateSongCover(){
        int currentIndex = getCurrentSongIndex();
        songimage.setImageResource(songCovers[currentIndex]);
    }
    private int getCurrentSongIndex(){
        return currentSongIndex;
    }



    private void playPreviousSong() {
        currentSongIndex = (currentSongIndex - 1 + songCovers.length) % songCovers.length;
        if (musicPlayer.isPlaying()) {
            musicPlayer.stop();
        }
        if(musicPlayer != null){
            musicPlayer.release();
        }
        //musicPlayer.release();
        musicPlayer = MediaPlayer.create(this, getSongResource(currentSongIndex));
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