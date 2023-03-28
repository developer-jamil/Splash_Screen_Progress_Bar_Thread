package com.jamillabltd.splashscreenprogressbarthread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    //splash screen
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        thread.start();


    }

    //splash screen
    public void doWork(){

        for (progress = 20; progress <= 100; progress =  progress + 20 ){
            try {
                Thread.sleep(150);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}