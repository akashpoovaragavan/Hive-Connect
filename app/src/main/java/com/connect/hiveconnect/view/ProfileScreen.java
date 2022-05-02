package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.connect.hiveconnect.R;

public class ProfileScreen extends AppCompatActivity {
    ImageView back;
    TextView title,logout;
    LinearLayout profile_pro,change_password,wallet,about,privacy,terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("Profile");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        profile_pro=findViewById(R.id.profile_pro);
        change_password=findViewById(R.id.change_password);
        wallet=findViewById(R.id.wallet);
        about=findViewById(R.id.about_us);
        privacy=findViewById(R.id.privacy_policy);
        terms=findViewById(R.id.terms_use);
        logout=findViewById(R.id.logout);
        profile_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileScreen.this,EditProfileScreen.class));
            }
        });
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileScreen.this,ChangePasswordScreen.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileScreen.this,LoginScreen.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}