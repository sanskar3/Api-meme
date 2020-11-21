package com.memelogy.www;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(homeIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);


////    ImageView imageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        ImageView imageView=findViewById(R.id.splash);
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
//            finish();
//            }
//        },3500);
    }
}
