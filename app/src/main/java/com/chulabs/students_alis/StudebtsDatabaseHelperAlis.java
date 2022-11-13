package com.chulabs.students_alis;/* Tom
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudebtsDatabaseHelperAlis extends SQLiteOpenHelper {

    private static final String DB_NAME = "students.db";
    private static final int DB_VERSION = 2;

    public StudebtsDatabaseHelperAlis(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String sqlText = "CREATE TABLE Groups (\n" +
                "id                       INTEGER    PRIMARY KEY AUTOINCREMENT,\n" +
                "number                   TEXT (10)  NOT NULL,\n" +
                "facultyName              TIME (100),\n" +
                "educationLevel           INTEGER,\n" +
                "contractExistsFlg        BOOLEAN,\n" +
                "privilageExistsFlg       BOOLEAN\n" +
        ");";
        sqLiteDatabase.execSQL(sqlText);

        updateShema(sqLiteDatabase, 0);

        populateDB(sqLiteDatabase);
    }

    private void populateDB(SQLiteDatabase db){
        populiteGroups(db);
        populateStudent(db);
    }

    private void populiteGroups(SQLiteDatabase db){
        for(StudentsGroup group: StudentsGroup.getGroups()) {
            insertRowToGroup(db, group);
        }
    }

    private void populateStudent(SQLiteDatabase db) {
        for(Student student: Student.getStudents()) {
            insertRowToStudent(db, student);
        }
    }


    private void insertRowToStudent(SQLiteDatabase db, Student student) {
        db.execSQL("insert into students(name, group_id)\n" +
                "select '"+student.getName()+"', id\n" +
                "from groups\n" +
                "where number='" + student.getGroupNamber() +"'");
    }

    private void insertRowToGroup(SQLiteDatabase db, StudentsGroup groups) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", groups.getNumber());
        contentValues.put("facultyName", groups.getFacultyName());
        contentValues.put("educationLevel", groups.getEducationLevel());
        contentValues.put("contractExistsFlg", groups.isContractExistsFlg());
        contentValues.put("privilageExistsFlg", groups.isPrivilageExistsFlg());
        db.insert("Groups", null, contentValues);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV){
        updateShema(sqLiteDatabase, oldV);
    }

    private void updateShema(SQLiteDatabase db, int oldV) {
        if(oldV < 2) {
            db.execSQL("CREATE TABLE Students (\n"+
                    "id            INTEGER   PRIMARY KEY AUTOINCREMENT, \n"+
                    "name          TEXT(100) NOT NULL,\n"+
                    "group_id      INTEGER   REFERENCES Groups(id) ON DELETE RESTRICT\n"+
                    "                                              ON UPDATE RESTRICT\n"+
                    ");");
            populateStudent(db);
        }
    }
}
