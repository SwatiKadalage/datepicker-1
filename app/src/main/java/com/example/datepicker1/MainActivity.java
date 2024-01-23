package com.example.datepicker1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text1=(EditText) findViewById(R.id.edit1);
        EditText text2=(EditText) findViewById(R.id.edit2);
        Button b1=(Button) findViewById(R.id.btn1);
        Button b2=(Button) findViewById(R.id.btn2);
        b1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat= new SimpleDateFormat("EEEE dd.MM.yyyy");
                Calendar currentCal = Calendar.getInstance();
                String currentdate=dateFormat.format(currentCal.getTime());
                currentCal.add(Calendar.DATE, 7);
                String toDate=dateFormat.format(currentCal.getTime());
                text1.setText(currentdate);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                Date currentLocalTime = cal.getTime();
                DateFormat date = new SimpleDateFormat("HH:mm a");
// you can get seconds by adding  "...:ss" to it
                date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));

                String localTime = date.format(currentLocalTime);
                text2.setText(localTime);

            }
        });


    }
}