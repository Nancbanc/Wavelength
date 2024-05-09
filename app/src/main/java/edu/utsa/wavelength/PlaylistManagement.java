package edu.utsa.wavelength;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;
//import androidx.appcompat.app.AppCompatActivity;

//public class PlaylistManagement extends AppCompatActivity {
public class PlaylistManagement extends ComponentActivity {

    private ImageButton addButton, homeButton, playerButton, searchButton;
    private ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlistmanagment); // Rename your layout appropriately

        //initializeViews();
        //setupListeners();
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

    /*

    private void initializeViews() {
        addButton = findViewById(R.id.addButton);
        homeButton = findViewById(R.id.homeButton);
        playerButton = findViewById(R.id.imageButton);
        searchButton = findViewById(R.id.imageButton5);
        profilePicture = findViewById(R.id.profilePicture);
    }

    private void setupListeners() {
        addButton.setOnClickListener(v -> {
            // Implement your logic for adding a new playlist
        });

        homeButton.setOnClickListener(v -> {
            // Navigate back to HomeActivity or whichever is your main activity
            finish();
        });

        playerButton.setOnClickListener(v -> {
            // Launch the music player
        });

        searchButton.setOnClickListener(v -> {
            // Perform search operations here
        });
    }

     */
}
