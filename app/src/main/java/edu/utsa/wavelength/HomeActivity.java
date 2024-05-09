package edu.utsa.wavelength;

import androidx.activity.ComponentActivity;
//import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HomeActivity extends ComponentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        setupButtons();
    }

        private void setupButtons() {

            ImageButton button1 = (ImageButton) findViewById(R.id.libraryButton);
            ImageButton button2 = (ImageButton) findViewById(R.id.equalizerButton);

            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, PlaylistManagement.class);
                    startActivity(intent);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, MusicActivity.class);
                    startActivity(intent);
                }
            });
        }
}
