package za.ac.cput.domain;

/*
* Abdul Aleem Chilwan - 220108447
* ADP3 - Final Capstone
* Domain - Parent.java
* October 2022
*/

import java.io.Serializable;



public class parent implements Serializable {
    private String parentCode;
    
    private String name;
    
    private String email;
    
    private String mobileNo;
    
    private String address;
    
    private String username;
    
    private String password;
    
    protected parent(){
    
    }
    
    private parent(parent.Builder builder) {
        this.parentCode = builder.parentCode;
        this.name = builder.name;
        this.email = builder.email;
        this.mobileNo = builder.mobileNo;
        this.username = builder.username;
        this.password = builder.password;
    }
    
    public String getParentCode() {
        return parentCode;
    }
    
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMobileNo() {
        return mobileNo;
    }
    
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
    
    @Override
    public String toString() {
        return "parent{" +
                "parentCode='" + parentCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    public static class Builder{
        private String parentCode;
        private String name;
        private String email;
        private String mobileNo;
        private String address;
        private String username;
        private String password;
    
        public parent.Builder parentCode(String parentCode) {
            this.parentCode = parentCode;
            return this;
        }
        public parent.Builder name(String name) {
            this.name = name;
            return this;
        }
        public parent.Builder email(String email) {
            this.email = email;
            return this;
        }
        public parent.Builder mobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }
        public parent.Builder address(String address) {
            this.address = address;
            return this;
        }
        public parent.Builder username(String username) {
            this.username = username;
            return this;
        }
        public parent.Builder password(String password) {
            this.password = password;
            return this;
        }
        public parent.Builder copy(parent s) {
            this.parentCode = s.parentCode;
            this.name = s.name;
            this.email = s.email;
            this.mobileNo = s.mobileNo;
            this.address = s.address;
            this.username = s.username;
            this.password = s.password;
            return this;
        }
        public parent build(){
            return new parent(this);
        }
    }
    
}
