package com.connect.hiveconnect.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.connect.hiveconnect.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateMeetingScreen extends AppCompatActivity {
    ImageView back;
    TextView title,m_date,m_time;
    LinearLayout meet_date,meet_time;
    int Hour,Minutes;
    AppCompatButton create_meet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting_screen);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("Create Meet ");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        m_date=findViewById(R.id.date);
        m_time=findViewById(R.id.time);
        meet_date=findViewById(R.id.meet_date);
        meet_time=findViewById(R.id.meet_time);
        create_meet=findViewById(R.id.create_meet);

        /// Date and Time
        Calendar calendar= Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        meet_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(CreateMeetingScreen.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        m_date.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        meet_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog=new TimePickerDialog(CreateMeetingScreen.this, android.R.style.Theme_Holo_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Hour=hourOfDay;
                        Minutes=minute;

                        String time=Hour+":"+Minutes;

                        SimpleDateFormat f24Hours= new SimpleDateFormat("HH:mm");
                        try {
                            Date date=f24Hours.parse(time);
                            SimpleDateFormat f12Hours=new SimpleDateFormat("hh:mm aa");
                            m_time.setText(f12Hours.format(date));
                        }catch (ParseException e){
                            e.printStackTrace();
                        }
                    }
                },12,0,false);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(Hour,Minutes);
                timePickerDialog.show();
            }
        });
        create_meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateMeetingScreen.this,PackageScreen.class));
            }
        });
    }
}