package edu.utsa.wavelength;

import androidx.activity.ComponentActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
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
    }
}
