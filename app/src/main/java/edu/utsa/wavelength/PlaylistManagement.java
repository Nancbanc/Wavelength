package edu.utsa.wavelength;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;

public class PlaylistManagement extends ComponentActivity {

    private ImageButton addButton, homeButton, playerButton, searchButton;
    private ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlistmanagment);

        ImageButton button1 = (ImageButton) findViewById(R.id.homeButton);
        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistManagement.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistManagement.this, MusicActivity.class);
                startActivity(intent);
            }
        });
    }
}
