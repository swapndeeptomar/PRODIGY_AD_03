package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * acts as the main activity in the Stopwatch application
 */

public class MainActivity extends AppCompatActivity {
    Button btn;
    Animation animImage, animText, animButton;
    ImageView mainImage;
    TextView mainTxt, subTxt;

    /**
     * sets the content view of the main activity
     * contains the main activity animations and onClick method
     *
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnGo);
        mainImage = findViewById(R.id.mainImg);
        mainTxt = findViewById(R.id.mainText);
        subTxt = findViewById(R.id.subText);

        //loading animations
        animImage = AnimationUtils.loadAnimation(this, R.anim.alg);
        animText = AnimationUtils.loadAnimation(this, R.anim.btgone);
        animButton = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        //passing animations
        mainImage.startAnimation(animImage);
        mainTxt.startAnimation(animText);
        subTxt.startAnimation(animText);
        btn.startAnimation(animButton);

        //setting button onClick to move to the next activity
        btn.setOnClickListener(new View.OnClickListener() {
            /**
             * uses the Intent class to move to the second activity when the button is clicked
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StopwatchHome.class);
                startActivity(intent);
            }
        });

    }//OnCreate
}//Class