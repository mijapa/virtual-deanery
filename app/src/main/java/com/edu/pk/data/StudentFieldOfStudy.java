package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "student_field_of_study", primaryKeys = {"fieldOfStudyNo", "niu"})
public class StudentFieldOfStudy {

    @NonNull
    private Integer fieldOfStudyNo;
    @NonNull
    private Integer niu;

    public StudentFieldOfStudy(@NonNull Integer fieldOfStudyNo, @NonNull Integer niu) {
        this.fieldOfStudyNo = fieldOfStudyNo;
        this.niu = niu;
    }

    @NonNull
    public Integer getFieldOfStudyNo() { return fieldOfStudyNo; }

    @NonNull
    public Integer getNiu() { return niu; }
}
