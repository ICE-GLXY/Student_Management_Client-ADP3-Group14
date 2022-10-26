package za.ac.cput.factory;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Factory - ParentFactory.java
 * October 2022
 */

import za.ac.cput.domain.parent;
import za.ac.cput.domain.school;
import za.ac.cput.util.Helper;

public class parentFactory {
    public static parent createParent(String parentCode, String name, String email, String mobileNo, String address, String username, String password){
        if (Helper.isEmpty(parentCode) || Helper.isEmpty(name) || Helper.isEmpty(email) || Helper.isEmpty(mobileNo)
                || Helper.isEmpty(address) || Helper.isEmpty(username) || Helper.isEmpty(password)){
            return null;
        }
        return new parent.Builder().parentCode(parentCode).name(name).email(email).mobileNo(mobileNo).address(address)
                .username(username).password(password).build();
    }
    
}
