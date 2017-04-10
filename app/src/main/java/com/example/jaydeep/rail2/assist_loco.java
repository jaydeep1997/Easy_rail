package com.example.jaydeep.rail2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

public class assist_loco extends AppCompatActivity {
    private TextView[] tv = new TextView[10];
    private EditText[] et = new EditText[10];
    int mYear,mMonth,mDay ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_loco);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        tv[1] = (TextView) findViewById(R.id.tv1);
        tv[2] = (TextView) findViewById(R.id.tv2);
        tv[3] = (TextView) findViewById(R.id.tv3);
        tv[4] = (TextView) findViewById(R.id.tv4);
        tv[5] = (TextView) findViewById(R.id.tv5);
        tv[6] = (TextView) findViewById(R.id.tv6);

        et[1] = (EditText) findViewById(R.id.et1);
        et[2] = (EditText) findViewById(R.id.et2);
        et[3] = (EditText) findViewById(R.id.et3);
        et[4] = (EditText) findViewById(R.id.et4);
        et[5] = (EditText) findViewById(R.id.et5);
        et[6] = (EditText) findViewById(R.id.et6);

        //Implement DatePicker
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        et[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog mdiDialog =new DatePickerDialog(assist_loco.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[3].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(assist_loco.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[4].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(assist_loco.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[5].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(assist_loco.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[6].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });

        final String fileName="assist_loco";
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

            for(int i=1;i<=6;i++)
            {
                //et[i].getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                String str=tv[i].getText().toString();
                String ans=et[i].getText().toString();
                if(ans.isEmpty() && success==true)
                {
                    success=false;
                    Toast.makeText(getApplicationContext(), "fill all the details", Toast.LENGTH_SHORT).show();
                    //et[i].getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
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
