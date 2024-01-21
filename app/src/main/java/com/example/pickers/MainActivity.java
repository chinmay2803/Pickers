package com.example.pickers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.b1);
        btn2=findViewById(R.id.b2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handletimebutton();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handledatebutton();
            }
        });
    }

    private void handledatebutton() {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int mon=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog d=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

               String d1="Selected date ="+i+"/"+(i1+1)+"/"+i2;
               Toast.makeText(MainActivity.this, ""+d1, Toast.LENGTH_SHORT).show();

            }
        },year,mon,day);
        d.show();
    }


    private void handletimebutton() {
        Calendar c2=Calendar.getInstance();
        int hour=c2.get(Calendar.HOUR_OF_DAY);
        int  min=c2.get(Calendar.MINUTE);
            TimePickerDialog t=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                String t1="Time="+i+":"+i1;
                Toast.makeText(MainActivity.this, ""+t1, Toast.LENGTH_SHORT).show();
                }
            },hour,min,false);
            t.show();
        }
    }
