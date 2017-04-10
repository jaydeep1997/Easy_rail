package com.example.jaydeep.rail2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

public class safety_equip extends AppCompatActivity {

    private CheckBox[] cb = new CheckBox[10];
    private TextView tv3;
    private EditText et3;

    private int mYear,mMonth,mDay ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_equip);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        cb[1] = (CheckBox) findViewById(R.id.cb1);
        cb[2] = (CheckBox) findViewById(R.id.cb2);
        cb[3] = (CheckBox) findViewById(R.id.cb3);

        tv3= (TextView) findViewById(R.id.tv3);
        et3= (EditText) findViewById(R.id.et3);

        //Implement DatePicker
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        et3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog mdiDialog =new DatePickerDialog(safety_equip.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //Toast.makeText(getApplicationContext(),year+ " "+monthOfYear+" "+dayOfMonth,Toast.LENGTH_LONG).show();
                        monthOfYear++;
                        et3.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                }, mYear, mMonth, mDay);
                mdiDialog.show();
            }

        });

        final String fileName="safety_equip";
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

            for(int i=1;i<=3;i++)
            {
                String str=cb[i].getText().toString();
                String ans;
                if(cb[i].isChecked())
                    ans="yes";
                else
                    ans="no";

                out.write((str+" :- "+ans+"\n").getBytes());

                if(i==2) {                                                  //also date of refilling
                    str = tv3.getText().toString();
                    ans = et3.getText().toString();
                    out.write((str + " :- " + ans + "\n").getBytes());
                }

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

                if(i==3)
                {
                    String[] str=line.split(" :- ");
                    if(str.length>=2)
                        et3.setText(str[1]);
                    line=reader.readLine();
                }

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
