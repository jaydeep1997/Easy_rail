package com.example.jaydeep.rail2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class part_1 extends AppCompatActivity {

    private TextView[] tv = new TextView[10];
    private RadioGroup[] rg = new RadioGroup[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_1);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        tv[1] = (TextView) findViewById(R.id.tv1);
        tv[2] = (TextView) findViewById(R.id.tv2);
        tv[3] = (TextView) findViewById(R.id.tv3);
        tv[4] = (TextView) findViewById(R.id.tv4);
        tv[5] = (TextView) findViewById(R.id.tv5);

        rg[1] = (RadioGroup) findViewById(R.id.rg1);
        rg[2] = (RadioGroup) findViewById(R.id.rg2);
        rg[3] = (RadioGroup) findViewById(R.id.rg3);
        rg[4] = (RadioGroup) findViewById(R.id.rg4);
        rg[5] = (RadioGroup) findViewById(R.id.rg5);

        final String fileName="part_1";
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

        boolean success=true;

        FileOutputStream out;
        try {
            out = openFileOutput(fileName, Context.MODE_PRIVATE);

            for(int i=1;i<=5;i++)
            {
                RadioButton rb1=((RadioButton)rg[i].getChildAt(0));
                RadioButton rb2=((RadioButton)rg[i].getChildAt(1));

                String str=tv[i].getText().toString();
                String ans="";

                if(rb1.isChecked())
                    ans="yes";
                else if(rb2.isChecked())
                    ans="no";
                if(ans.isEmpty() && success==true)
                {
                    success = false;
                    Toast.makeText(getApplicationContext(), "fill all the details", Toast.LENGTH_SHORT).show();
                }
                out.write((str+" :- "+ans+"\n").getBytes());
            }

            //deleteFile(fileName);
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return success;

    }

    void ReadFile(String fileName)
    {

        FileInputStream in;
        try {
            in = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            int i=1;
            while ((line = reader.readLine()) != null) {

                String[] str=line.split(" :- ");
                //Toast.makeText(getApplicationContext(), str[1], Toast.LENGTH_SHORT).show();
                if(str.length>=2)
                    if(str[1].equals("yes"))
                        //Toast.makeText(getApplicationContext(), str[1], Toast.LENGTH_SHORT).show();
                        ((RadioButton)rg[i].getChildAt(0)).setChecked(true);
                    else if(str[1].equals("no"))
                        ((RadioButton)rg[i].getChildAt(1)).setChecked(true);
                i++;
            }

            reader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
