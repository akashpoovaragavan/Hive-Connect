package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.connect.hiveconnect.R;

public class JoinMeetScreen extends AppCompatActivity {
    ImageView back;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_meet_screen);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("Join Meeting");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}