package za.ac.cput.domain;
/*
 * Mogamad Taariq Phillips - 220166153
 * user.java
 * Creation of attributes for the user entity
 *
 */

import java.io.Serializable;

public class user implements Serializable {

    private String emailAddress;

    private String password;

    private String passwordConfirmation;

    private int grade;

    private String userType;

    protected user(){

    }

    //private builder constructor
    private user(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.passwordConfirmation = builder.passwordConfirmation;
        this.grade = builder.grade;
        this.userType = builder.userType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    @Override
    public String toString() {
        return "user{" +
                "emailAddress='" + emailAddress + '\'' +
                ", Password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                ", grade=" + grade +
                ", userType='" + userType + '\'' +
                '}';
    }

    public static class Builder {
        private String emailAddress;
        private String password;
        private String passwordConfirmation;
        private int grade;
        private String userType;


        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder Password(String Password) {
            this.password = Password;
            return this;
        }

        public Builder passwordConfirmation(String passwordConfirmation) {
            this.passwordConfirmation = passwordConfirmation;
            return this;
        }

        public Builder grade(int grade) {
            this.grade = grade;
            return this;
        }

        public Builder userType(String userType) {
            this.userType = userType;
            return this;
        }

        public Builder copy(user d) {
            this.emailAddress = d.emailAddress;
            this.password = d.password;
            this.passwordConfirmation = d.passwordConfirmation;
            this.grade = d.grade;
            this.userType = d.userType;

            return this;
        }

        public user build() {
            return new user(this);
        }


    }
}