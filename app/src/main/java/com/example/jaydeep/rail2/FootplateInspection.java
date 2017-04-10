package com.example.jaydeep.rail2;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FootplateInspection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footplate_inspection);

    }



    public void onClick(View v){

        Intent intent = null;

        switch(v.getId()){

            case R.id.train_info: intent = new Intent(FootplateInspection.this, train_info.class);
                break;

            case R.id.loco_pilot: intent = new Intent(FootplateInspection.this, loco_pilot.class);
                break;

            case R.id.assistant_loco: intent = new Intent(FootplateInspection.this, assist_loco.class);
                break;

            case R.id.personal_store: intent = new Intent(FootplateInspection.this, personal_store.class);
                break;

            case R.id.safety_equipments: intent = new Intent(FootplateInspection.this, safety_equip.class);
                break;

            case R.id.partI: intent = new Intent(FootplateInspection.this, part_1.class);
                break;

            case R.id.partII: intent = new Intent(FootplateInspection.this, part_2.class);
                break;

            case R.id.partIII: intent = new Intent(FootplateInspection.this, part_3.class);
                break;

            case R.id.loco_pilot_knowledge: intent = new Intent(FootplateInspection.this, knowledge.class);
                break;

            case R.id.submit:
                Toast.makeText(getApplicationContext(), "Form submitted successfuly.", Toast.LENGTH_SHORT).show();
                intent = new Intent(FootplateInspection.this, MainActivity.class);
                break;

            default: Log.i("main","this is error in switch as default gets here.");

        }
        startActivity(intent);
    }
}
