package za.ac.cput.domain;

/*
 * Author Lelihle Gazi - (214258041)
 * mark.java
 * Created domain entity for mark class
 * Capstone Project
 * 2022
 */

import java.io.Serializable;



public class mark implements Serializable {

    private String markID;

    private String markDescription;

    private String markStudentId;

    private String markSubjectId;

    private float markResult;

    protected mark() {
    }

    //builder constructor
    private mark(Builder builder) {
        this.markID = builder.markID;
        this.markDescription = builder.markDescription;
        this.markStudentId = builder.markStudentID;
        this.markSubjectId = builder.markSubjectId;
        this.markResult = builder.markResult;

    }

    public String getMarkID() {
        return markID;
    }

    public void setMarkID(String markID) {
        this.markID = markID;
    }

    public String getMarkDescription() {
        return markDescription;
    }

    public void setMarkDescription(String markDescription) {
        this.markDescription = markDescription;
    }

    public String getMarkStudentId() {
        return markStudentId;
    }

    public void setMarkStudentId(String markStudentId) {
        this.markStudentId = markStudentId;
    }

    public String getMarkSubjectId() {
        return markSubjectId;
    }

    public void setMarkSubjectId(String markSubjectId) {
        this.markSubjectId = markSubjectId;
    }

    public float getMarkResult() {
        return markResult;
    }

    public void setMarkResult(float markResult) {
        this.markResult = markResult;
    }

    @Override
    public String toString() {
        return "mark{" +
                "markID='" + markID + '\'' +
                ", markDescription='" + markDescription + '\'' +
                ", markStudentId='" + markStudentId + '\'' +
                ", markSubjectId='" + markSubjectId + '\'' +
                ", markResult=" + markResult +
                '}';
    }

    public static class Builder {
        private String markID;
        private String markDescription;
        private String markStudentID;
        private String markSubjectId;
        private float markResult;

        public Builder markID(String markID) {
            this.markID = markID;
            return this;
        }

        public Builder markDescription(String markDescription) {
            this.markDescription = markDescription;
            return this;
        }

        public Builder markStudentID(String markStudentID) {
            this.markStudentID = markStudentID;
            return this;
        }

        public Builder markSubjectId(String markSubjectId) {
            this.markSubjectId = markSubjectId;
            return this;
        }

        public Builder markResult(float markResult) {
            this.markResult = markResult;
            return this;
        }

        public Builder copy(mark mark) {
            this.markID = mark.markID;
            this.markDescription = mark.markDescription;
            this.markStudentID = mark.markStudentId;
            this.markSubjectId = mark.markSubjectId;
            this.markResult = mark.markResult;
            return this;
        }

        public mark build() {
            return new mark(this);
        }
    }
}