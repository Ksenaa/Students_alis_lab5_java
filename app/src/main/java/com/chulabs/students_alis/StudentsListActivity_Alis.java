package com.chulabs.students_alis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;
import android.view.View;



public class StudentsListActivity_Alis extends AppCompatActivity {
    public static final String GROUP_NUMBER = "groupnumber";
    private float textSize = 0;

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putFloat("textSize", textSize);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list_alis);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);

        String txtStudents = "";
        for (Student s : Student.getStudents(grpNumber)) {
            txtStudents += s.getName() + "\n";
        }

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(txtStudents);

        textSize = textView.getTextSize();
        if (savedInstanceState != null){
            textSize = savedInstanceState.getFloat("textSize");
        }

    }

    public void onSendBtnClick(View view) {
        TextView textView = (TextView) findViewById(R.id.text);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Список студентів");
        startActivity(intent);
    }

    public void onPlusBtnClick(View view) {
        textSize = textSize * 1.1f;
        TextView textView = findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

    }

}