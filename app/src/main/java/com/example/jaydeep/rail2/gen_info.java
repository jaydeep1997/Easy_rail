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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class gen_info extends AppCompatActivity {
    private TextView[] tv = new TextView[25];
    private RadioGroup[] rg = new RadioGroup[25];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_info);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        tv[1] = (TextView) findViewById(R.id.tv1);
        tv[2] = (TextView) findViewById(R.id.tv2);
        tv[3] = (TextView) findViewById(R.id.tv3);
        tv[4] = (TextView) findViewById(R.id.tv4);
        tv[5] = (TextView) findViewById(R.id.tv5);
        tv[6] = (TextView) findViewById(R.id.tv6);
        tv[7] = (TextView) findViewById(R.id.tv7);
        tv[8] = (TextView) findViewById(R.id.tv8);
        tv[9] = (TextView) findViewById(R.id.tv9);
        tv[10] = (TextView) findViewById(R.id.tv10);
        tv[11] = (TextView) findViewById(R.id.tv11);
        tv[12] = (TextView) findViewById(R.id.tv12);
        tv[13] = (TextView) findViewById(R.id.tv13);
        tv[14] = (TextView) findViewById(R.id.tv14);
        tv[15] = (TextView) findViewById(R.id.tv15);
        tv[16] = (TextView) findViewById(R.id.tv16);
        tv[17] = (TextView) findViewById(R.id.tv17);
        tv[18] = (TextView) findViewById(R.id.tv18);
        tv[19] = (TextView) findViewById(R.id.tv19);
        tv[20] = (TextView) findViewById(R.id.tv20);

        rg[1] = (RadioGroup) findViewById(R.id.rg1);
        rg[2] = (RadioGroup) findViewById(R.id.rg2);
        rg[3] = (RadioGroup) findViewById(R.id.rg3);
        rg[4] = (RadioGroup) findViewById(R.id.rg4);
        rg[5] = (RadioGroup) findViewById(R.id.rg5);
        rg[6] = (RadioGroup) findViewById(R.id.rg6);
        rg[7] = (RadioGroup) findViewById(R.id.rg7);
        rg[8] = (RadioGroup) findViewById(R.id.rg8);
        rg[9] = (RadioGroup) findViewById(R.id.rg9);
        rg[10] = (RadioGroup) findViewById(R.id.rg10);
        rg[11] = (RadioGroup) findViewById(R.id.rg11);
        rg[12] = (RadioGroup) findViewById(R.id.rg12);
        rg[13] = (RadioGroup) findViewById(R.id.rg13);
        rg[14] = (RadioGroup) findViewById(R.id.rg14);
        rg[15] = (RadioGroup) findViewById(R.id.rg15);
        rg[16] = (RadioGroup) findViewById(R.id.rg16);
        rg[17] = (RadioGroup) findViewById(R.id.rg17);
        rg[18] = (RadioGroup) findViewById(R.id.rg18);
        rg[19] = (RadioGroup) findViewById(R.id.rg19);
        rg[20] = (RadioGroup) findViewById(R.id.rg20);

        final String fileName="gen_info";
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

            for(int i=1;i<=20;i++)
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
                if(str.length>=2)                   //if str[1] exists (not empty)
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
