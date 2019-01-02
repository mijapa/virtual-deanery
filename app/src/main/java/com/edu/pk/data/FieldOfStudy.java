package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "field_of_study")
public class FieldOfStudy {

    @PrimaryKey(autoGenerate = true)
    private Integer fieldOfStudyNo;
    @NonNull
    private String fieldOfStudyName;
    @NonNull
    private String department;

    public FieldOfStudy(@NonNull String fieldOfStudyName, @NonNull String department) {
        this.fieldOfStudyName = fieldOfStudyName;
        this.department = department;
    }

    public Integer getFieldOfStudyNo() { return fieldOfStudyNo; }

    @NonNull
    public String getFieldOfStudyName() { return fieldOfStudyName; }

    @NonNull
    public String getDepartment() { return department; }

    public void setFieldOfStudyNo(Integer fieldOfStudyNo) {
        this.fieldOfStudyNo = fieldOfStudyNo;
    }

    public String toString(){
        return getDepartment() + " " + getFieldOfStudyName();
    }

}
