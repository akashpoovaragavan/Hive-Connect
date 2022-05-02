package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.connect.hiveconnect.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HostScreen extends AppCompatActivity {
    ImageView back;
    TextView title;
    FloatingActionButton create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_screen);
        title=findViewById(R.id.title);
        title.setText("Meeting List");
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        create=findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HostScreen.this,CreateMeetingScreen.class));
            }
        });
    }
}