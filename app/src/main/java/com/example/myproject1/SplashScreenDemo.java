package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenDemo extends AppCompatActivity {

    private static int splashTimeOut = 2000;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_demo);


        text = findViewById(R.id.splashTextId);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenDemo.this,Navigation.class);
                startActivity(intent);
                finish();
            }
        },splashTimeOut);


        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);

        text.startAnimation(myanim);

    }
}
