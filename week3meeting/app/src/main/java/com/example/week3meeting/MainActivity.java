package com.example.week3meeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button)findViewById(R.id.b1);
        TextView tv1 = (TextView) findViewById(R.id.t1);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File dir = new File(MainActivity.this.getFilesDir(), "week3");
                String filename = "week3manytimes.txt";
                //Checking if directory exists
                if(!dir.exists())
                {
                    dir.mkdir();
                }

                try {

                    File file = new File(dir,filename);

                    //appending data many times to the same file
                    FileWriter writer = new FileWriter(file, true);
                    writer.append(tv1.getText().toString());
                    writer.append("\n");
                    writer.append(bt1.getText().toString());
                    writer.close();
                    Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}