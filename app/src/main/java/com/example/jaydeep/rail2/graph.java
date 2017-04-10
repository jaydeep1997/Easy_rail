package com.example.jaydeep.rail2;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.location.Location;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.*;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class graph extends AppCompatActivity {

    private ToggleButton toggle;
    private Button refresh;
    ArrayAdapter adapter;
    private GPStracker gps;
    double longitude1,longitude2;
    double latitude1,latitude2;
    Location loc,prevLoc;
    double distance,total=0;
    long time1=0,time2=0,startTime=0;
    GraphView graph;

    //list cantaining lat, long, time, distance
    final List<String> list = new ArrayList<>();
    //String[] StringArray = {"jaydeep","Khandelwal","Raghav","Khandelwal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        toggle = (ToggleButton)findViewById(R.id.toggle);
        refresh = (Button)findViewById(R.id.refresh);
        graph = (GraphView) findViewById(R.id.graph);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            public void run() {
                getNewLocation();
                handler.postDelayed(this, 1000 * 60 * 4);

            }
        };
        adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.textview, R.id.tv, list);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);

        createGraph();

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    // The toggle is enabled
                    list.clear();
                    handler.removeCallbacks(runnable);
                } else {
                    // The toggle is disabled
                    startTime=Calendar.getInstance().getTimeInMillis();
                    runnable.run();

                }
            }
        });

        refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createGraph2();

            }
        });



    }


    void createGraph(){
        try{
            String points="";
            InputStream in = getAssets().open("test_graph.txt");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);

            points=new String(buffer);
            String[] lines = points.split(System.getProperty("line.separator"));

            //Toast.makeText(getApplicationContext(), ""+lines[1], Toast.LENGTH_SHORT).show();
            DataPoint[] dataPoints = new DataPoint[lines.length];

            for(int i=0;i<lines.length;i++) {
                String[] str = lines[i].split(" ");
                dataPoints[i] = new DataPoint(Float.parseFloat(str[0]), Float.parseFloat(str[1]));
                //Toast.makeText(getApplicationContext(), ""+dataPoints[i].getX()+dataPoints[i].getY(), Toast.LENGTH_SHORT).show();
            }

            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
            // styling series
            series.setColor(Color.GREEN);
            series.setDrawDataPoints(true);

            graph.addSeries(series);

            graph.setTitle("Allahabad-Lucknow");
            graph.setTitleTextSize(60);
            graph.setTitleColor(Color.BLUE);
            // custom label formatter to show currency "EUR"
            graph.getViewport().setScrollable(true); // enables horizontal scrolling
            //graph.getViewport().setScrollableY(true); // enables vertical scrolling
            graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
            //graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void createGraph2(){

        DataPoint[] dataPoints = new DataPoint[list.size()];

        for(int i=0;i<list.size();i++){
            String[] str = list.get(i).split(" ");
            dataPoints[i] = new DataPoint(Float.parseFloat(str[2]), Float.parseFloat(str[4]));
            //Toast.makeText(getBaseContext(), str[4], Toast.LENGTH_SHORT).show();
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
        // styling series
        series.setColor(Color.RED);
        series.setDrawDataPoints(true);

        graph.addSeries(series);

        graph.setTitleTextSize(60);
        graph.setTitleColor(Color.BLUE);
        // custom label formatter to show currency "EUR"
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        //graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        //graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling

    }

    //self
    void getNewLocation(){
        gps = new GPStracker(graph.this);
        if(gps.canGetLocation()){
            longitude1 = gps.getLongitude();
            latitude1 = gps .getLatitude();
            loc = gps.getLocation2();
            time1= Calendar.getInstance().getTimeInMillis();
            if(prevLoc==null) {
                time2=startTime;
                //Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
                prevLoc = loc;
            }
            distance=loc.distanceTo(prevLoc);
            total+=distance;

            list.add(longitude1+" "+latitude1+" "+((time1-startTime)/1000/60)+" "+distance+ " "+total);
//            for(int i=0;i<list.size();i++)
//                Toast.makeText(getBaseContext(), list[i], Toast.LENGTH_SHORT);
            adapter.notifyDataSetChanged();
            prevLoc=loc;
            time2=time1;
        }
        else
        {
            gps.showSettingsAlert();
        }

    }



}
