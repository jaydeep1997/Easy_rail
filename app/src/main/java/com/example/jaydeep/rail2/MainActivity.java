package com.example.jaydeep.rail2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        //        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        //toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {
        //    drawer.closeDrawer(GravityCompat.START);
        //} else {
            super.onBackPressed();
        //}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }


    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_train) {
            Intent i = new Intent(getApplicationContext(), train_info.class);
            startActivity(i);
            // Handle the Train action
        } else if (id == R.id.nav_loco) {
            Intent i = new Intent(getApplicationContext(), loco_pilot.class);
            startActivity(i);
        } else if (id == R.id.nav_personal) {
            Intent i = new Intent(getApplicationContext(), personal_store.class);
            startActivity(i);
        } else if (id == R.id.nav_assistant) {
            Intent i = new Intent(getApplicationContext(), assist_loco.class);
            startActivity(i);
        } else if (id == R.id.nav_safety) {
            Intent i = new Intent(getApplicationContext(), safety_equip.class);
            startActivity(i);
        } else if (id == R.id.nav_part_1) {
            Intent i = new Intent(getApplicationContext(), part_1.class);
            startActivity(i);
        } else if (id == R.id.nav_part_2) {
            Intent i = new Intent(getApplicationContext(), part_2.class);
            startActivity(i);
        } else if (id == R.id.nav_part_3) {
            Intent i = new Intent(getApplicationContext(), part_3.class);
            startActivity(i);
        } else if (id == R.id.nav_knowledge) {
            Intent i = new Intent(getApplicationContext(), knowledge.class);
            startActivity(i);
        }else if (id == R.id.nav_graph) {
            Intent i = new Intent(getApplicationContext(), graph.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            //sent an email to jaydeepkhandelwal97@gmail.com
            /*
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"jaydeepkhandelwal97@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT   , "Message Body");

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
                Log.i("Finished sending...", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }




        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/


    public void onClick(View v){
        Intent intent = null;

        switch(v.getId()){

            case R.id.enter:

                String user=username.getText().toString();
                String pass=password.getText().toString();

                SQLiteDatabase mydb = openOrCreateDatabase("mydb",MODE_PRIVATE,null);

                Cursor resultSet = mydb.rawQuery("Select * from users WHERE username="+"\""+user+"\";",null);
                //Toast.makeText(getBaseContext(),""+resultSet.getCount(),Toast.LENGTH_SHORT).show();
                if(resultSet.getCount() == 0)
                    Toast.makeText(getBaseContext(),"Username doesn't exist",Toast.LENGTH_SHORT).show();
                else {
                    resultSet.moveToNext();
                    if (!pass.equals(resultSet.getString(1))) {
                        Toast.makeText(getBaseContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                    else
                        intent = new Intent(MainActivity.this, home_page.class);
                }

                break;
            case R.id.register:
                intent = new Intent(MainActivity.this, register_page.class);
                break;

            default: Log.i("main","You gotta a default");
        }

        if(intent != null)
            startActivity(intent);
    }




}
