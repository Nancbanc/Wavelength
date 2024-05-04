package edu.utsa.wavelength;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.*;
import androidx.annotation.Nullable;

public class MainActivity extends ComponentActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //setContentView(R.layout.homepage);
        setupButtons();
    }
    private void setupButtons(){
        Button button1 = (Button) findViewById(R.id.login);
        Button button2 = (Button) findViewById(R.id.register);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uText = (EditText)findViewById(R.id.inputName);
                EditText pText = (EditText)findViewById(R.id.inputPassword);
                int id = authenticate(uText.getText().toString(), pText.getText().toString());
                if(id > 0){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
                else{
                    uText.setText("");
                    pText.setText("");
                    uText.setError("Incorrect username and password combination.");
                    pText.setError("Incorrect username and password combination.");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private int authenticate(String username, String password){
        Scanner scan;
        String str = "";
        String[] arr = null;
        boolean authenticated = false;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath() + "/login.txt");

        try {
            if(f.exists()) {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (username.equalsIgnoreCase(arr[1]) && password.equals(arr[2])) {
                        id = Integer.parseInt(arr[0]);
                        break;
                    }
                }
                scan.close();
            }
        }
        catch(IOException e){
            Toast.makeText(this,"Error: "+ e.getMessage(), Toast.LENGTH_SHORT);
        }

        return id;
        //return username.equalsIgnoreCase(arr[1]) && password.equals(arr[2]);

    }
}
