package com.android.audioplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean clicked = true;
    Button start,stop;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        Intent service = new Intent(getApplicationContext(),CustomPlayer.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(clicked)
                {
                    startService(service);
                    clicked = false;

                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent service = new Intent(getApplicationContext(),CustomPlayer.class);
                if(!clicked)
                {
                    stopService(service);
                    clicked  = true;
                }
            }
        });


    }
}