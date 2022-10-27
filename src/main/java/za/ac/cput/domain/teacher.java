package za.ac.cput.domain;

/* Author Lelihle Gazi - (214258041)
 * teacher.java
 * Created entity for teacher class
 * Capstone Project
 * 2022
 */

import java.io.Serializable;

public class teacher implements Serializable {

    private String teacherID;

    private String username;

    private String password;

    private String email;

    protected teacher() {
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private teacher(Builder builder){
        this.teacherID = builder.teacherID;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;

    }

    @Override
    public String toString() {
        return "teacher{" +
                "teacherID='" + teacherID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder {
        private String teacherID;
        private String username;
        private String password;
        private String email;

        public Builder teacherID(String teacherID){
            this.teacherID = teacherID;
            return this;
        }

        public Builder userName(String userName){
            this.username = userName;
            return this;
        }
        public Builder password(String password){
            this.password= password;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder copy(teacher teacher){
            this.teacherID = teacher.teacherID;
            this.username = teacher.username;
            this.password = teacher.password;
            this.email = teacher.email;
            return this;

        }
        public teacher build(){
            return  new teacher(this);
        }

    }
}