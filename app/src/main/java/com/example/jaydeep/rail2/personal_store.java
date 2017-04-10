package com.example.jaydeep.rail2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class personal_store extends AppCompatActivity {
    private CheckBox[] cb = new CheckBox[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_store);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        cb[1] = (CheckBox) findViewById(R.id.cb1);
        cb[2] = (CheckBox) findViewById(R.id.cb2);
        cb[3] = (CheckBox) findViewById(R.id.cb3);
        cb[4] = (CheckBox) findViewById(R.id.cb4);
        cb[5] = (CheckBox) findViewById(R.id.cb5);
        cb[6] = (CheckBox) findViewById(R.id.cb6);

        final String fileName="personal_store";
        ReadFile(fileName);
        Button button = (Button) findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean success=WriteFile(fileName);
                //come to home page
                if(success) {
                    Toast.makeText(getApplicationContext(), "data successfully saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    boolean WriteFile(String fileName)
    {
        deleteFile(fileName);

        FileOutputStream out;
        try {
            out = openFileOutput(fileName, Context.MODE_PRIVATE);

            for(int i=1;i<=6;i++)
            {
                String str=cb[i].getText().toString();
                String ans;
                if(cb[i].isChecked())
                    ans="yes";
                else
                    ans="no";

                out.write((str+" :- "+ans+"\n").getBytes());
            }

            //deleteFile(fileName);
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return true;

    }

    void ReadFile(String fileName)
    {
        Button b= (Button) findViewById(R.id.ok);

        FileInputStream in;
        try {
            in = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            int i=1;
            while ((line = reader.readLine()) != null) {

                String[] str=line.split(" :- ");
                //Toast.makeText(getApplicationContext(), str[1], Toast.LENGTH_SHORT).show();
                if(str[1].equals("yes"))
                    //Toast.makeText(getApplicationContext(), str[1], Toast.LENGTH_SHORT).show();
                    cb[i].setChecked(true);
                else
                    cb[i].setChecked(false);
                i++;
            }

            reader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
