package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.connect.hiveconnect.R;

public class PackageScreen extends AppCompatActivity {
    ImageView back;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_screen);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("Subscribe Packages ");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}