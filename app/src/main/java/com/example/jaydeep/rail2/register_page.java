package com.example.jaydeep.rail2;

import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register_page extends AppCompatActivity {

    Button reg;
    EditText[] et = new EditText[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        reg=(Button)findViewById(R.id.reg);
        et[1]= (EditText) findViewById(R.id.et1);
        et[2]= (EditText) findViewById(R.id.et2);
        et[3]= (EditText) findViewById(R.id.et3);
        et[4]= (EditText) findViewById(R.id.et4);
        et[5]= (EditText) findViewById(R.id.et5);
        et[6]= (EditText) findViewById(R.id.et6);


        reg.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                boolean success=registerUser();

                if(success==true)
                {
                    Toast.makeText(getApplicationContext(), "You are successfully registered", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

        });

    }


    public boolean registerUser()
    {
        boolean success=true;

        try {
            // Your insert code block here
            SQLiteDatabase mydb = openOrCreateDatabase("mydb",MODE_PRIVATE,null);

            mydb.execSQL("CREATE TABLE IF NOT EXISTS users(username VARCHAR,password VARCHAR,name VARCHAR,email VARCHAR,headQuarter VARCHAR, " +
                    "PRIMARY KEY(username));");

            String username=et[4].getText().toString();
            String password=et[5].getText().toString();
            String ppassword=et[6].getText().toString();
            String name=et[1].getText().toString();
            String email=et[2].getText().toString();
            String headquarter=et[3].getText().toString();


            if(username.isEmpty() || password.isEmpty() | name.isEmpty() || email.isEmpty() || headquarter.isEmpty())
            {
                Toast.makeText(getBaseContext(),"Fill all the details",Toast.LENGTH_SHORT).show();
                success=false;
            }
            else if(!password.equals(ppassword))
            {
                Toast.makeText(getBaseContext(),"Password doesn't match",Toast.LENGTH_SHORT).show();
                success=false;
            }
            else
            {
                mydb.execSQL("INSERT INTO users VALUES(\""+username+"\",\""+ password+"\",\""+ name+"\",\""+ email+"\",\""+ headquarter+"\");");
            }


        } catch (SQLiteConstraintException e) {
            // Show error message here
            Toast.makeText(getBaseContext(),"Username Already taken",Toast.LENGTH_SHORT).show();
            success=false;

        }

        return success;
    }


}
