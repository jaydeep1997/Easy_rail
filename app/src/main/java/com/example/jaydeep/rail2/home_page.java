package com.example.jaydeep.rail2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void onClick(View v){

        Intent intent = null;

        switch(v.getId()){

            case R.id.footplate: intent = new Intent(getApplicationContext(), FootplateInspection.class);
                break;

            case R.id.graph: intent = new Intent(getApplicationContext(), graph.class);
                break;

            case R.id.other: intent = new Intent(getApplicationContext(), OtherInspection.class);
                break;

            default: Log.i("main","You gotta a default");
        }

        if(intent != null)
            startActivity(intent);
    }
}
