package com.example.iotapp;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.startbtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Start button pressed",Toast.LENGTH_LONG).show();
                Intent startservice = new Intent(MainActivity.this,DataService.class);
                startService(startservice);

            }
        });

        Button stop = findViewById(R.id.stopbtn);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopservice = new Intent(MainActivity.this,DataService.class);
                stopService(stopservice);
            }
        });

    }
}