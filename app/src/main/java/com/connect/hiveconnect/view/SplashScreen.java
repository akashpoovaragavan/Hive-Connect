package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.connect.hiveconnect.R;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences onboardscreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onboardscreen=getSharedPreferences("Onboardingscreen",MODE_PRIVATE);
                boolean isfirsttime= onboardscreen.getBoolean("First time",true);
                if (isfirsttime) {
                    SharedPreferences.Editor editor=onboardscreen.edit();
                    editor.putBoolean("First time",false);
                    editor.commit();
                    Intent intent= new Intent(SplashScreen.this, OnBoardScreen.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent= new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);
    }
}