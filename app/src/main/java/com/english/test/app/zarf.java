package com.english.test.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class zarf extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5;
    int dogrusayisi = 0;
    int yanlissayisi = 0;
    int secilen;
    int sorusayisi=168;
    TextView tx1,tx2;
    public int soruhizi=settings.soruhizi;
    ArrayList<String> array;
    ArrayList<String> array2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zarf);
        AdView adViewz;
        adViewz = (AdView) findViewById(R.id.adViewz);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.iconn);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adViewz.loadAd(adRequest);
        adViewz.setAdListener(new AdListener(){
            @java.lang.Override
            public void onAdLoaded(){
                super.onAdLoaded();
            }


        });
            tx2 = (TextView)findViewById(R.id.dy);
            tx1=(TextView)findViewById(R.id.txt_z_soru);
            b1 = (Button)findViewById(R.id.btn_z_a);
            b2 = (Button)findViewById(R.id.btn_z_b);
            b3 = (Button)findViewById(R.id.btn_z_c);
            b4 = (Button)findViewById(R.id.btn_z_d);
            b5 = (Button)findViewById(R.id.btn_z_e);

            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);
            b4.setOnClickListener(this);
            b5.setOnClickListener(this);

            sorugetir();
            cevaplar();
            butonayarla();

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.back_item: Intent i = new Intent(zarf.this, MainActivity.class);
                    startActivity(i);
                    return true;
                case R.id.setitem: Intent i2 = new Intent(zarf.this, settings.class);
                    startActivity(i2);
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.btn_z_a: clickset(b1, 1); break;
                case R.id.btn_z_b: clickset(b2, 2); break;
                case R.id.btn_z_c: clickset(b3, 3); break;
                case R.id.btn_z_d: clickset(b4, 4); break;
                case R.id.btn_z_e: clickset(b5, 5); break;


            }
        }

    public void clickset(Button b, int x){
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
        b5.setClickable(false);
        kontrol(x);
        b.postDelayed(new Runnable() {

            @Override
            public void run() {

                sorugetir(); butonayarla();
                b1.setClickable(true);
                b2.setClickable(true);
                b3.setClickable(true);
                b4.setClickable(true);
                b5.setClickable(true);
            }
        }, soruhizi);

    }
    public void butonayarla(){

        butonrenk(b1,"def");
        butonrenk(b2,"def");
        butonrenk(b3,"def");
        butonrenk(b4,"def");
        butonrenk(b5,"def");

        Random r1 = new Random();
        Random r = new Random();

        switch (r1.nextInt(5)){
            case 0:
                b1.setText(array2.get(secilen));
                b2.setText(array2.get(r.nextInt(sorusayisi)));
                b3.setText(array2.get(r.nextInt(sorusayisi)));
                b4.setText(array2.get(r.nextInt(sorusayisi)));
                b5.setText(array2.get(r.nextInt(sorusayisi)));
                controlbutton();
                break;
            case 1:
                b2.setText(array2.get(secilen));
                b1.setText(array2.get(r.nextInt(sorusayisi)));
                b3.setText(array2.get(r.nextInt(sorusayisi)));
                b4.setText(array2.get(r.nextInt(sorusayisi)));
                b5.setText(array2.get(r.nextInt(sorusayisi)));
                controlbutton();
                break;
            case 2:
                b3.setText(array2.get(secilen));
                b2.setText(array2.get(r.nextInt(sorusayisi)));
                b1.setText(array2.get(r.nextInt(sorusayisi)));
                b4.setText(array2.get(r.nextInt(sorusayisi)));
                b5.setText(array2.get(r.nextInt(sorusayisi)));
                controlbutton();
                break;
            case 3:
                b4.setText(array2.get(secilen));
                b2.setText(array2.get(r.nextInt(sorusayisi)));
                b3.setText(array2.get(r.nextInt(sorusayisi)));
                b1.setText(array2.get(r.nextInt(sorusayisi)));
                b5.setText(array2.get(r.nextInt(sorusayisi)));
                controlbutton();
                break;
            case 4:
                b5.setText(array2.get(secilen));
                b2.setText(array2.get(r.nextInt(sorusayisi)));
                b3.setText(array2.get(r.nextInt(sorusayisi)));
                b4.setText(array2.get(r.nextInt(sorusayisi)));
                b1.setText(array2.get(r.nextInt(sorusayisi)));
                controlbutton();
                break;

        }


    }
    public void sorugetir(){

        Random r = new Random();
        secilen = r.nextInt(sorusayisi);
        FileInputStream fr= null;
        TextView tt=(TextView) findViewById(R.id.txt_z_soru);
        array =new ArrayList<String>();
        try {
            InputStream is = getResources().openRawResource(R.raw.adverbssoru);
            InputStreamReader isr=new InputStreamReader(is, Charset.forName("ISO-8859-9"));

            BufferedReader bf=new BufferedReader(isr);
            String line=bf.readLine();
            while(line!=null){
                array.add(line);
                line=bf.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tt.setText(array.get(secilen));

    }
    public void cevaplar(){

        FileInputStream fr= null;
        array2 =new ArrayList<String>();
        try {
            InputStream is = getResources().openRawResource(R.raw.adverbscevap);
            InputStreamReader isr=new InputStreamReader(is, Charset.forName("ISO-8859-9"));
            BufferedReader bf=new BufferedReader(isr);
            String line=bf.readLine();
            while(line!=null){
                array2.add(line);
                line=bf.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void kontrol(int x){

        switch (x){
            case 1: if(array2.get(secilen)==b1.getText()){
                butonrenk(b1,"dogru");
                dogrusayisi++;
                dogruyanlisguncelle();

            }else{
                butonrenk(b1,"yanlis");
                tx1.setText(tx1.getText()+"\n Cevap: "+array2.get(secilen));
                yanlissayisi++;
                dogruyanlisguncelle();

            }
                break;
            case 2: if(array2.get(secilen)==b2.getText()) {
                butonrenk(b2,"dogru");
                dogrusayisi++;
                dogruyanlisguncelle();

            }else{
                butonrenk(b2,"yanlis");
                tx1.setText(tx1.getText()+"\n Cevap: "+array2.get(secilen));
                yanlissayisi++;
                dogruyanlisguncelle();

            }
                break;
            case 3:if(array2.get(secilen)==b3.getText()) {
                butonrenk(b3,"dogru");
                dogrusayisi++;
                dogruyanlisguncelle();

            }else{
                butonrenk(b3,"yanlis");
                tx1.setText(tx1.getText()+"\n Cevap: "+array2.get(secilen));
                yanlissayisi++;
                dogruyanlisguncelle();

            }
                break;
            case 4: if(array2.get(secilen)==b4.getText()) {
                butonrenk(b4,"dogru");
                dogrusayisi++;
                dogruyanlisguncelle();

            }else{
                butonrenk(b4,"yanlis");
                tx1.setText(tx1.getText()+"\n Cevap: "+array2.get(secilen));
                yanlissayisi++;
                dogruyanlisguncelle();

            }
                break;
            case 5: if(array2.get(secilen)==b5.getText()) {
                butonrenk(b5,"dogru");
                dogrusayisi++;
                dogruyanlisguncelle();

            }else{
                butonrenk(b5,"yanlis");
                tx1.setText(tx1.getText()+"\n Cevap: "+array2.get(secilen));
                yanlissayisi++;
                dogruyanlisguncelle();

            }
                break;

        }

    }
    public void butonrenk(Button b, String durum){

        switch(durum){
            case "dogru": b.setBackgroundResource(R.color.dogru); break;
            case "yanlis": b.setBackgroundResource(R.color.yanlis);break;
            case "def": b.setBackgroundResource(R.drawable.common_google_signin_btn_icon_dark_normal_background); break;

        }
    }
    public void dogruyanlisguncelle(){
        tx2.setText("DOĞRU: "+dogrusayisi+" YANLIŞ: "+yanlissayisi);

    }
    public void controlbutton(){

        if(b1.getText() == b2.getText() || b1.getText() == b3.getText() || b1.getText() == b4.getText() || b1.getText()== b5.getText()
                || b2.getText() == b3.getText() || b2.getText() == b4.getText() || b2.getText()==b5.getText()
                || b3.getText() == b4.getText() || b3.getText() == b5.getText()
                || b4.getText() == b5.getText())
        {
            b4.setText(array2.get(secilen));
            b2.setText("doğal olarak");
            b3.setText("yenilikçilik");
            b1.setText("görgüsüzce");
            b5.setText("gündelik");

        }

    }
}

