package com.github.imran.timedatepicker;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.DateDialogListener,TimePickerFragment.TimeDialogListener{
    private static final String DIALOG_DATE = "MainActivity.DateDialog";
    private static final String DIALOG_TIME = "MainActivity.TimeDialog";

    private TextView showDate;
    private TextView showTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDate= (TextView) findViewById(R.id.showDate);
        showTime= (TextView) findViewById(R.id.showTime);

    }

    public void pickTime(View view) {
        TimePickerFragment dialog = new TimePickerFragment();
        dialog.show(getSupportFragmentManager(), DIALOG_TIME);
    }

    public void pickDate(View view) {
        DatePickerFragment dialog = new DatePickerFragment();
        dialog.show(getSupportFragmentManager(), DIALOG_DATE);
    }

    @Override
    public void onFinishDialog(Date date) {
        showDate.setText(formatDate(date));
    }

    public String formatDate(Date date) {
        String hireDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        hireDate = sdf.format(date);
        return hireDate;
    }

    @Override
    public void onFinishDialog(String time) {
        showTime.setText(time);
    }
}
