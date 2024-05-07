package edu.utsa.wavelength.ui.theme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.ArrayList;

public class PlaylistManagement extends AppCompatActivity {

    private GridView gridView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> playlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playlists = new ArrayList<>();
        playlists.add("Playlist 1");
        playlists.add("Playlist 2");
        playlists.add("Playlist 3");

        gridView = findViewById(R.id.playlistGrid);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playlists);
        gridView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        ImageButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            // Add new playlist logic
        });

        ImageView profilePicture = findViewById(R.id.profilePicture);
        profilePicture.setOnClickListener(v -> {
            // Profile viewing/editing logic
        });

        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            // Home button logic
        });

        ImageButton otherButton = findViewById(R.id.otherButton);
        otherButton.setOnClickListener(v -> {
            // Other functionality
        });
    }
}

