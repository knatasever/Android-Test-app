package com.english.test.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class settings extends AppCompatActivity {

    static int soruhizi=1300;
    int deger;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
           ActionBar actionBar = getSupportActionBar();
           actionBar.setDisplayShowHomeEnabled(true);
           actionBar.setIcon(R.mipmap.iconn);
        Button b = (Button)findViewById(R.id.b);
        SeekBar sb = (SeekBar)findViewById(R.id.sb);
        deger = sb.getProgress();
        sb.setProgress(50);
           AdView adset;
           adset = (AdView) findViewById(R.id.adsetting);
           AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
           adset.loadAd(adRequest);
           adset.setAdListener(new AdListener(){
               @java.lang.Override
               public void onAdLoaded(){
                   super.onAdLoaded();
               }


           });


           b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(settings.this, MainActivity.class);
                startActivity(i);

            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
              if(progress<20){
                  soruhizi=2000;

              }else if(progress<40){
                  soruhizi=1600;

              }else if (progress<60){
                  soruhizi=1200;
              }else if(progress<80){
                  soruhizi=1000;
              }else{
                  soruhizi=800;
              }


            }
        });
    }
}
