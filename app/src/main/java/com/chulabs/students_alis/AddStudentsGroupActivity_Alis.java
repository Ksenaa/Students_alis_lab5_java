package com.chulabs.students_alis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class AddStudentsGroupActivity_Alis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_group_alis);
    }

    public void onGrpAddClick(View view){
        EditText number = (EditText)findViewById(R.id.addGroupNumber);
        EditText faculty = (EditText) findViewById(R.id.addFaculty);
        SQLiteOpenHelper sqLiteOpenHelper = new StudebtsDatabaseHelperAlis(this);
        try{
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("number", number.getText().toString());
            contentValues.put("facultyName", faculty.getText().toString());
            contentValues.put("educationLevel", 0);
            contentValues.put("contractExistsFlg", 0);
            contentValues.put("privilageExistsFlg", 0);
            db.insert("groups",null,contentValues);
            db.close();
            NavUtils.navigateUpFromSameTask(this);
        }catch(SQLiteException e) {
            Toast toast = Toast.makeText(this,
                    "Database unavailable",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}