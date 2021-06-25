package com.example.writing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    FileOutputStream fos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button)findViewById(R.id.button);
        TextView tv1 = (TextView)findViewById(R.id.textView);
        TextView file = (TextView)findViewById(R.id.filetext);
        File dir  = new File(MainActivity.this.getFilesDir(),"testdir");

        if (!dir.exists())
        {
            dir.mkdir();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = String.valueOf(file.getText());
                File fp = new File(dir,filename);

                byte [] vals = String.valueOf(tv1.getText()).getBytes();
                try {
                    fos = new FileOutputStream(fp,true);
                    fos.write(vals);
                    fos.write("\n".getBytes());



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}