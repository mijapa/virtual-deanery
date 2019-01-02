package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "field_of_study_course", primaryKeys = {"fieldOfStudyNo", "courseNo"})
public class FieldOfStudyCourse {

    @NonNull
    private Integer fieldOfStudyNo;
    @NonNull
    private Integer courseNo;

    public FieldOfStudyCourse(@NonNull Integer fieldOfStudyNo, @NonNull Integer courseNo) {
        this.fieldOfStudyNo = fieldOfStudyNo;
        this.courseNo = courseNo;
    }

    @NonNull
    public Integer getFieldOfStudyNo() { return fieldOfStudyNo; }

    @NonNull
    public Integer getCourseNo() { return courseNo; }

}
