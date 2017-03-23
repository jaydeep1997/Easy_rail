package com.example.jaydeep.rail2;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static com.example.jaydeep.rail2.R.id.et1;

public class train_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_info);

        ReadFile();
        Button button = (Button) findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WriteFile();
                Toast.makeText(getApplicationContext(), "data successfully saved", Toast.LENGTH_SHORT).show();
                //come to home page
            }
        });

    }


    void WriteFile()
    {
        String fileName="train_info";
        deleteFile(fileName);
        /*
        String filename="train_info";
        String string="hello world"+"\n";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.write(string.getBytes());
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        TextView[] tv = new TextView[15];
        tv[1] = (TextView) findViewById(R.id.tv1);
        tv[2] = (TextView) findViewById(R.id.tv2);
        tv[3] = (TextView) findViewById(R.id.tv3);
        tv[4] = (TextView) findViewById(R.id.tv4);
        tv[5] = (TextView) findViewById(R.id.tv5);
        tv[6] = (TextView) findViewById(R.id.tv6);
        tv[7] = (TextView) findViewById(R.id.tv7);
        tv[8] = (TextView) findViewById(R.id.tv8);
        tv[9] = (TextView) findViewById(R.id.tv9);

        EditText[] et = new EditText[15];
         et[1] = (EditText) findViewById(R.id.et1);
         et[2] = (EditText) findViewById(R.id.et2);
         et[3] = (EditText) findViewById(R.id.et3);
         et[4] = (EditText) findViewById(R.id.et4);
         et[5] = (EditText) findViewById(R.id.et5);
         et[6] = (EditText) findViewById(R.id.et6);
         et[7] = (EditText) findViewById(R.id.et7);
         et[8] = (EditText) findViewById(R.id.et8);
         et[9] = (EditText) findViewById(R.id.et9);


        FileOutputStream out;
        try {
            out = openFileOutput(fileName, Context.MODE_PRIVATE);

            for(int i=1;i<=9;i++)
            {
                String str=tv[i].getText().toString();
                String ans=et[i].getText().toString();
                out.write((str+"!"+ans+"\n").getBytes());
            }

            //deleteFile(fileName);
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }

    void ReadFile()
    {
        /*
        String fileName="train_info";
        String string;
        byte[] buffer = new byte[10];
        FileInputStream inputStream;
        try {
            inputStream = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                Toast.makeText(getApplicationContext(), line, Toast.LENGTH_SHORT).show();
            }

            reader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        TextView[] tv = new TextView[15];
        tv[1] = (TextView) findViewById(R.id.tv1);
        tv[2] = (TextView) findViewById(R.id.tv2);
        tv[3] = (TextView) findViewById(R.id.tv3);
        tv[4] = (TextView) findViewById(R.id.tv4);
        tv[5] = (TextView) findViewById(R.id.tv5);
        tv[6] = (TextView) findViewById(R.id.tv6);
        tv[7] = (TextView) findViewById(R.id.tv7);
        tv[8] = (TextView) findViewById(R.id.tv8);
        tv[9] = (TextView) findViewById(R.id.tv9);

        EditText[] et = new EditText[15];
        et[1] = (EditText) findViewById(R.id.et1);
        et[2] = (EditText) findViewById(R.id.et2);
        et[3] = (EditText) findViewById(R.id.et3);
        et[4] = (EditText) findViewById(R.id.et4);
        et[5] = (EditText) findViewById(R.id.et5);
        et[6] = (EditText) findViewById(R.id.et6);
        et[7] = (EditText) findViewById(R.id.et7);
        et[8] = (EditText) findViewById(R.id.et8);
        et[9] = (EditText) findViewById(R.id.et9);


        String fileName="train_info";
        byte[] buffer = new byte[50];
        FileInputStream in;
        try {
            in = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            int i=1;
            while ((line = reader.readLine()) != null) {

                String[] str=line.split("!");
                //Toast.makeText(getApplicationContext(), str[1], Toast.LENGTH_SHORT).show();
                et[i].setText(str[1]);
                i++;

            }

            reader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
