package com.english.test.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {
    Intent i1,i2,i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdView adViewm;
        adViewm = (AdView) findViewById(R.id.adviewmain);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adViewm.loadAd(adRequest);
        adViewm.setAdListener(new AdListener(){
            @java.lang.Override
            public void onAdLoaded(){
                super.onAdLoaded();
            }


        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.iconn);

        Button b1 = (Button)findViewById(R.id.verbs);
        Button b2 = (Button)findViewById(R.id.adjective);
        Button b3 = (Button)findViewById(R.id.zarf);
        i1 = new Intent(this, verbsclass.class);
        i2 = new Intent(this, adjclass.class);
        i3 = new Intent(this, zarf.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i2);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i3);

            }
        });
    }

}
