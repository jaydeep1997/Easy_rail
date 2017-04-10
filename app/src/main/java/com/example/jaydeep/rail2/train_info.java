package com.example.jaydeep.rail2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;


import static com.example.jaydeep.rail2.R.id.et1;

public class train_info extends AppCompatActivity {

    private static EditText[] et = new EditText[20];
    private String[] tv;
    private AutoCompleteTextView actv1,actv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_info);

        //dont show keyboard initially
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        tv = new String[]{"Train-Info", "Train No.", "Engine No.","Base","Load","OPRS No./MV5 No.","From Station","To Station","Departure Time","Arrival Time","Air Pressure","Train Engine", "Brake Van","Total No. Of Cylinders","No. Of Effective Cylinders","Brake power %"};


        et[1] = (EditText) findViewById(R.id.et1);
        et[2] = (EditText) findViewById(R.id.et2);
        et[3] = (EditText) findViewById(R.id.et3);
        et[4] = (EditText) findViewById(R.id.et4);
        et[5] = (EditText) findViewById(R.id.et5);
        et[8] = (EditText) findViewById(R.id.et8);
        et[9] = (EditText) findViewById(R.id.et9);
        et[10] = (EditText) findViewById(R.id.et10);
        et[11] = (EditText) findViewById(R.id.et11);
        et[12] = (EditText) findViewById(R.id.et12);
        et[13] = (EditText) findViewById(R.id.et13);
        et[14] = (EditText) findViewById(R.id.et14);
        et[15] = (EditText) findViewById(R.id.et15);

        actv1= (AutoCompleteTextView)findViewById(R.id.et6);
        actv2= (AutoCompleteTextView)findViewById(R.id.et7);

        //Implement rimePicker
        Calendar mcurrentTime = Calendar.getInstance();

        et[8].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(train_info.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        et[8].setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        et[9].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(train_info.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        et[9].setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        //Implement Auto Complete Text
        try{
            String stations="" ;
            InputStream in = getAssets().open("stations.txt");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);

            stations=new String(buffer);
            String[] lines = stations.split(System.getProperty("line.separator"));

            //Toast.makeText(getApplicationContext(), stations, Toast.LENGTH_SHORT).show();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,lines);
            //Getting the instance of AutoCompleteTextView
            actv1.setThreshold(1);//will start working from first character
            actv2.setThreshold(1);//will start working from first character
            actv1.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
            actv2.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Retrieve and Saving Data
        final String fileName="train_info";
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
            for(int i=1;i<=15;i++)
            {
                String str=tv[i];
                String ans;
                Log.d("1",""+i);
                if(i==6)
                    ans=actv1.getText().toString();
                else if(i==7)
                    ans=actv2.getText().toString();
                else {
                    //et[i].getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                    ans = et[i].getText().toString();
                }

                //Log.d("2",""+i);
                //Toast.makeText(getBaseContext(), "j"+ans+"k"+i, Toast.LENGTH_SHORT).show();

                if(ans.isEmpty() && success==true)
                {
                    success=false;
                    Toast.makeText(getBaseContext(), "fill all the details", Toast.LENGTH_SHORT).show();
//                    if(i!=6 && i!=7)
//                        et[i].getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                }

                out.write((str+" :- "+ans+"\n").getBytes());
                //Toast.makeText(getBaseContext(), str+" :- "+ans, Toast.LENGTH_SHORT).show();
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

        //read timepicker and set to button text




        //-------------------------------------

        FileInputStream in;
        try {
            in = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            int i=1;
            while ((line = reader.readLine()) != null) {

                String[] str=line.split(" :- ");
//                Log.d("line",line);
//                Log.d("str0",str[0]);
//                //Log.d("str1",str[1]);
                if(str.length>=2)                   //if str[1] exists (not empty)
                {
                    if (i == 6)
                        actv1.setText(str[1]);
                    else if (i == 7)
                        actv2.setText(str[1]);
                    else
                        et[i].setText(str[1]);
                }
                i++;
            }

            reader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
