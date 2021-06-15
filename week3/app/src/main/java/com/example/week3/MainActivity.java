package com.example.week3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b1 = (Button) findViewById(R.id.button1);
        TextView t1 = (TextView) findViewById(R.id.text1);
        b1.setOnClickListener(new View.OnClickListener()
                              {
                                  public FileWriter writer;

                                  @Override
                                  public void onClick(View view) {


                                      File dir = new File(MainActivity.this.getFilesDir(), "week3");
                                      String filename ="week3single.txt";
                                      if (!dir.exists()) {
                                          dir.mkdir();
                                      }
                                      try {
                                          File file = new File(dir,filename);
                                          //writes only once to the file
                                          writer = new FileWriter(file,false);
                                          writer.append(t1.getText().toString());
                                          writer.append("\n");
                                          writer.append(b1.getText().toString());
                                          writer.close();
                                          Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
                                      } catch (Exception e) { }

                                  }
                              }



        );
    }
}