package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * acts as the second activity of the Stopwatch application
 */

public class StopwatchHome extends AppCompatActivity {
    private Chronometer stopwatch;
    private boolean timerRunning;
    private long pausedTime;
    Button btnstart, btnpause, btnreset;

    /**
     * sets the content view of the second activity
     * contains the second activity animations and OnCLick methods
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch_home);

        btnstart = findViewById(R.id.btnStart);
        btnpause = findViewById(R.id.btnPause);
        btnreset = findViewById(R.id.btnReset);
        stopwatch = findViewById(R.id.timer);

        //creating starting optional animation
        btnpause.setAlpha(0);
        btnreset.setAlpha(0);


        btnstart.setOnClickListener(new View.OnClickListener() {

            /**
             * checks whether the timer is running - if NO sets the chronometer to start
             * sets the chronometer base value to start from where it was paused before
             * (excludes sleep time)
             * sets the timerRunning variable to true
             * makes the pause and reset buttons visible with an animation
             */
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    //Setting the Chronometer start time
                    stopwatch.setBase(SystemClock.elapsedRealtime() - pausedTime);
                    stopwatch.start();
                    timerRunning = true;
                    //animation to hide/show required buttons
                    btnstart.animate().alpha(0);
                    btnpause.animate().alpha(1).setDuration(300).start();
                    btnreset.animate().alpha(1).setDuration(300).start();
                }
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {

            /**
             * checks whether the timer is running - if YES sets the chronometer to stop
             * stores the current timer value in the pausedTime variable
             * sets the timerRunning variable to false
             * makes the start button visible with an animation
             */
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    stopwatch.stop();
                    //Taking the current time passed
                    pausedTime = SystemClock.elapsedRealtime() - stopwatch.getBase();
                    timerRunning = false;
                    //animation to hide/show required buttons
                    btnstart.animate().alpha(1).setDuration(300).start();
                }
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            /**
             * resets the chronometer, and the pausedTime, timeRunning variables
             * stops the chronometer at 00:00
             * makes the pause, reset buttons disappear and start button appear
             */
            @Override
            public void onClick(View v) {
                stopwatch.setBase(SystemClock.elapsedRealtime());
                stopwatch.stop();
                pausedTime = 0;
                timerRunning = false;
                //animation to hide/show required buttons
                btnstart.animate().alpha(1).setDuration(300).start();
                btnpause.animate().alpha(0);
                btnreset.animate().alpha(0);
            }
        });

    }//OnCreate
}//Class
