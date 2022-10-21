package com.chulabs.students_alis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private int seconds = 0;
    private Boolean isRunning = true;
    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run()   {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
        }
        runTimer();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
    }

    public void onBtnClick(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String grpNumb = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this, StudentsListActivity_Alis.class);
        intent.putExtra(StudentsListActivity_Alis.GROUP_NUMBER, grpNumb);

        startActivity(intent);
    }
    @Override
    protected void onStart(){
        super.onStart();
        isRunning = true;
    }
    @Override
    protected void onStop(){
        super.onStop();
        isRunning = false;
    }

    public void onGrpBtnClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String grpNumb = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this, StudentsGroupActivity_Alis.class);
        intent.putExtra(StudentsListActivity_Alis.GROUP_NUMBER, grpNumb);

        startActivity(intent);
    }
}