package com.chulabs.students_alis;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private String groupNamber;

    public Student(String name, String groupNamber){
        this.name = name;
        this.groupNamber = groupNamber;
    }
    public String getName() {
        return name;
    }
    public String getGroupNamber(){
        return groupNamber;
    }
    private final static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student ("Алісова Ксенія", "301"),
                    new Student ("Єрмолінський Данііл", "301"),
                    new Student ("Зайцев Володимир", "302"),
                    new Student ("Петренко Сергій", "302"),
                    new Student ("Пирогов Владислав", "308"),
                    new Student ("Погорілий Дмитро", "308"),
                    new Student ("Полеводін Євгеній", "309"),
                    new Student ("Решетник Катерина", "309")
            )
    );
    public static  ArrayList<Student> getStudents(String groupNamber){
        ArrayList<Student> stList = new ArrayList<>();
        for(Student s: students) {
            if (s.getGroupNamber().equals(groupNamber)){
                stList.add(s);
            }
        }
        return stList;
    }
}
