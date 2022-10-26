package za.ac.cput.factory;
/*
 * Author Lelihle Gazi - (214258041)
 * markFactory.java
 * Created object for mark class
 * Capstone Project
 * 2022
 */

import za.ac.cput.domain.mark;
import za.ac.cput.util.Helper;

public class markFactory {
    public  static mark createMark(String markID, String markDescription, String MarkStudentId, String MarkSubjectId , float MarkResult){

        if(Helper.isEmpty(markID) || Helper.isEmpty(markDescription) || Helper.isEmpty(MarkStudentId) || Helper.isEmpty(MarkSubjectId))
            return null;

        return new mark.Builder()
                .markID(markID)
                .markDescription(markDescription)
                .markStudentID(MarkStudentId)
                .markSubjectId(MarkSubjectId)
                .markResult(MarkResult)
                .build();
    }
}


