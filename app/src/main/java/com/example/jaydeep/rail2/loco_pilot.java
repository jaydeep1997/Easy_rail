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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class loco_pilot extends AppCompatActivity {

    private EditText[] et = new EditText[15];
    private TextView[] tv = new TextView[15];

    private int mYear,mMonth,mDay ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loco_pilot);

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

        et[1] = (EditText) findViewById(R.id.et1);
        et[2] = (EditText) findViewById(R.id.et2);
        et[3] = (EditText) findViewById(R.id.et3);
        et[4] = (EditText) findViewById(R.id.et4);
        et[5] = (EditText) findViewById(R.id.et5);
        et[6] = (EditText) findViewById(R.id.et6);
        et[7] = (EditText) findViewById(R.id.et7);
        et[8] = (EditText) findViewById(R.id.et8);
        et[9] = (EditText) findViewById(R.id.et9);
        et[10] = (EditText) findViewById(R.id.et10);
        et[11] = (EditText) findViewById(R.id.et11);
        et[12] = (EditText) findViewById(R.id.et12);
        et[13] = (EditText) findViewById(R.id.et13);

        //Implement DatePicker
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        et[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
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
        et[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[7].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[8].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[9].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[10].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[11].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });
        et[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog  mdiDialog =new DatePickerDialog(loco_pilot.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et[13].setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();

            }

        });

        final String fileName="loco_pilot";
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

            for(int i=1;i<=13;i++)
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
            //for radio button
            String str=tv[14].getText().toString();
            String ans;

            RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
            RadioButton rb1=((RadioButton)rg.getChildAt(0));
            RadioButton rb2=((RadioButton)rg.getChildAt(1));
            if(rb1.isChecked())
                ans="yes";
            else
                ans="no";
            out.write((str+" :- "+ans+"\n").getBytes());
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

        byte[] buffer = new byte[50];
        FileInputStream in;
        try {
            in = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            int i=1;
            while ((line = reader.readLine()) != null) {

                String[] str=line.split(" :- ");
                //Toast.makeText(getApplicationContext(), str[1], Toast.LENGTH_SHORT).show();
                if(i==14)   //set radio button
                {
                    RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
                    RadioButton rb1=((RadioButton)rg.getChildAt(0));
                    RadioButton rb2=((RadioButton)rg.getChildAt(1));
                    if(str.length>=2)
                        if (str[1].equals("yes"))
                            rb1.setChecked(true);
                        else if(str[1].equals("no"))
                            rb2.setChecked(true);
                }
                else
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
