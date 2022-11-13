package com.chulabs.students_alis;/* Tom
 */

import java.util.ArrayList;
import java.util.Arrays;

public class StudentsGroup {
    private int id;
    private String number;
    private String facultyName;
    private int educationLevel;
    private boolean contractExistsFlg;
    private boolean privilageExistsFlg;


    public StudentsGroup(int id, String number, String facultyName, int educationLevel, boolean contractExistsFlg, boolean privilageExistsFlg){
        this.number = number;
        this.facultyName = facultyName;
        this.educationLevel = educationLevel;
        this.contractExistsFlg = contractExistsFlg;
        this.privilageExistsFlg = privilageExistsFlg;
        this.id = id;
    }
    public StudentsGroup(String number, String facultyName,int educationLevel,
                         boolean contractExistsFlg,boolean privilageExistsFlg){
    }

    public int getId() {return  this.id; }

    public String getNumber() {
        return number;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public int getEducationLevel(){
        return educationLevel;
    }

    public boolean isContractExistsFlg(){
        return contractExistsFlg;
    }

    public boolean isPrivilageExistsFlg(){ return privilageExistsFlg;
    }
    private static ArrayList<StudentsGroup> groups = new ArrayList<StudentsGroup>(
            Arrays.asList(
                    new StudentsGroup("ІПЗ19-1", "Інноваційнх технологій", 0, true, false),
                    new StudentsGroup("ІПЗ19-2", "Інноваційнх технологій", 0, true, false),
                    new StudentsGroup("К19-1", "Інноваційнх технологій", 0, true, false),
                    new StudentsGroup("ІПЗ22м", "Інноваційнх технологій", 1, false, true)
            )
    );

    public static StudentsGroup getGroup(String groupNumber) {
        for(StudentsGroup g: groups) {
            if (g.getNumber().equals(groupNumber)) {
                return g;
            }
        }
        return null;
    }

    public static ArrayList<StudentsGroup> getGroups(){
        return groups;
    }
    @Override
    public String toString(){
        return number;
    }

    public static void addGroup(StudentsGroup group) {groups.add(group);}
}
