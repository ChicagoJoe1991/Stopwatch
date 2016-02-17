package com.example.walter.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



public class StopwatchActivity extends AppCompatActivity {
    private boolean running;
    private int seconds = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }
    public void onClickStart(View view){
        running = true;
    }
    public void onClickStop(View view){
        running = false;
    }
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }
    private void runTimer(){
        //get the TextView
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        //create a new handler
        final Handler handler = new Handler();
        //call the post() method, passing in a new Runnable. The post() method processes codes
        //without a delay, so the code in the Runnable will run almost immediately
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = seconds / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }

}
