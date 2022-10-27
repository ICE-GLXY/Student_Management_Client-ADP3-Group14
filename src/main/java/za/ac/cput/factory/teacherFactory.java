package za.ac.cput.factory;
/*
 * Author Lelihle Gazi - (214258041)
 * teacherFactory.java
 * Created an object for teacher class
 * Capstone Project
 * 2022
 */

import za.ac.cput.domain.teacher;
import za.ac.cput.util.Helper;

public class teacherFactory {

    public static teacher createTeacher(String teacherID, String username, String password, String email) {

        if (!Helper.isValidEmail(email))
            return null;

        if (Helper.isEmpty(teacherID) || Helper.isEmpty(username) || Helper.isEmpty(password))
            return null;

        return new teacher.Builder()
                .teacherID(teacherID)
                .userName(username)
                .password(password)
                .email(email)
                .build();
    }
}