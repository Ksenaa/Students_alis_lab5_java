package com.chulabs.students_alis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class AddStudentsGroupActivity_Alis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_group_alis);
    }

    public void onGrpAddClick(View view){
        EditText number = (EditText)findViewById(R.id.addGroupNumber);
        EditText faculty = (EditText) findViewById(R.id.addFaculty);
        StudentsGroup.addGroup(
                new StudentsGroup(number.getText().toString(), faculty.getText().toString(), 0, false, false)
        );
        NavUtils.navigateUpFromSameTask(this);
    }
}