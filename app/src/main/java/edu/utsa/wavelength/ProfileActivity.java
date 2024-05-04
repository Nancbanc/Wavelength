package edu.utsa.wavelength;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProfileActivity extends ComponentActivity {

    private Account profileInfo;
    //private AssetManager assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        profileInfo = null;
        //assets = getAssets();
        setupProfile();
    }

    public void setupProfile(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        //profileInfo = new Account(id, assets);
        File f = new File(getFilesDir().getAbsolutePath() + "/accounts.txt");
        Scanner scan;
        String str = "";
        String[] arr = null;

        try {
            if(f.exists()) {
                scan = new Scanner(openFileInput("accounts.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (Integer.parseInt(arr[0]) == id) {
                        profileInfo = new Account(id, arr[1], arr[2]);
                        break;
                    }
                }
                scan.close();
            }
        }
        catch(IOException e){
            //System.out.println("Error: " + e.getMessage());
            Toast.makeText(this,"Error: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        if(profileInfo != null) {
            TextView name = (TextView) findViewById(R.id.fullName);
            TextView email = (TextView) findViewById(R.id.jdoeemail);

            name.setText(profileInfo.getName());
            email.setText(profileInfo.getEmail());
        }
    }
}
