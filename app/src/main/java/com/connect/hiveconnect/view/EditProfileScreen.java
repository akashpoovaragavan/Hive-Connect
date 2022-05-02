package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.connect.hiveconnect.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class EditProfileScreen extends AppCompatActivity {
    ImageView back;
    TextView title;
    TextInputEditText dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_screen);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("Edit Profile");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dob=findViewById(R.id.dob);


        Calendar calendar= Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(EditProfileScreen.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        dob.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }
}