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
                    new Student ("Алісова Ксенія", "ІПЗ19-1"),
                    new Student ("Єрмолінський Данііл", "ІПЗ19-1"),
                    new Student ("Зайцев Володимир", "ІПЗ19-2"),
                    new Student ("Петренко Сергій", "ІПЗ19-2"),
                    new Student ("Пирогов Владислав", "К19-1"),
                    new Student ("Погорілий Дмитро", "К19-1"),
                    new Student ("Полеводін Євгеній", "К19-2"),
                    new Student ("Решетник Катерина", "К19-2")
            )
    );
    public static ArrayList<Student> getStudents() {
        return getStudents("");
    }
    public static  ArrayList<Student> getStudents(String groupNamber){
        ArrayList<Student> stList = new ArrayList<>();
        for(Student s: students) {
            if (s.getGroupNamber().equals(groupNamber) || (groupNamber == "")){
                stList.add(s);
            }
        }
        return stList;
    }
    @Override
    public String toString() {
        return name;
    }
}
