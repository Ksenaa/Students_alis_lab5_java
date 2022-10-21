package com.chulabs.students_alis;

import static com.chulabs.students_alis.StudentsListActivity_Alis.GROUP_NUMBER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class StudentsGroupActivity_Alis extends AppCompatActivity {
    private static final int LONG_DELAY = 3500; // 3.5 seconds

    private static final int SHORT_DELAY = 2000; // 2 seconds


    public static final String GROUP_NUMBER = "groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_group2_alis);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
        StudentsGroup
                group = StudentsGroup.getGroup(grpNumber);
        EditText txtGrpNumber = (EditText) findViewById(R.id.grpNumberEdit);
        txtGrpNumber.setText(group.getNumber());


        EditText txtFacultyName = (EditText) findViewById(R.id.facultyEdit);
        txtFacultyName.setText(group.getFacultyName());

        TextView txtImgGrp = (TextView) findViewById(R.id.grpNumberImageTxt);
        txtImgGrp.setText(group.getNumber());

        TextView txtImgFaculty = (TextView) findViewById(R.id.facultyNameImageTxt);
        txtImgFaculty.setText(group.getFacultyName());

        if (group.getEducationLevel() == 0) {
            ((RadioButton) findViewById(R.id.edu_level_bachelor)).setChecked(true);
        } else {
            ((RadioButton) findViewById(R.id.edu_level_master)).setChecked(true);
        }
        ((CheckBox) findViewById(R.id.contract_flg)).setChecked(
                group.isContractExistsFlg()
        );
        ((CheckBox) findViewById(R.id.privilege_flg)).setChecked(
                group.isPrivilageExistsFlg()
        );
    }
    public void onOkBntClick(View view){
        String outString = "Група " + ((TextView) findViewById(R.id.grpNumberEdit)).getText();

        outString += "; Факультет " + ((TextView) findViewById(R.id.facultyEdit)).getText();

        if (((RadioButton) findViewById(R.id.edu_level_master)).isChecked()) {
            outString += ", рівень освіти - " + "магістр";
        } else {
            outString += ", рівень освіти - " + "бакалавр";
        }

        if (((CheckBox) findViewById(R.id.contract_flg)).isChecked()) {
            outString += ", контрактники є";
        } else {
            outString += ", контрактників нема";
        }

        if (((CheckBox) findViewById(R.id.privilege_flg)).isChecked()){
            outString += ", є пільговики";
        } else {
            outString += ", пільговиків нема";
        }
        Toast.makeText(this, outString, Toast.LENGTH_LONG).show();

    }
}