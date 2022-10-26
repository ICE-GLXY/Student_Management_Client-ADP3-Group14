package za.ac.cput.factory;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Factory - SchoolFactory.java
 * October 2022
 */
import za.ac.cput.domain.school;
import za.ac.cput.util.Helper;

public class schoolFactory {
    public static school createSchool(String code, String name){
        if (Helper.isEmpty(code) || Helper.isEmpty(name)){
            return null;
        }
        return new school.Builder().schoolCode(code).schoolName(name).build();
    }
}
