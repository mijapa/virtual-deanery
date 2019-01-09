package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "grade", primaryKeys = {"niu", "courseNo"})
public class Grade {
    @NonNull
    private Integer niu;
    @NonNull
    private Integer courseNo;
    @NonNull
    private Integer grade;

    public Grade(@NonNull Integer niu, @NonNull Integer courseNo, @NonNull Integer grade) {

        this.niu = niu;
        this.courseNo = courseNo;
        this.grade = grade;
    }

    @NonNull
    public Integer getNiu() {
        return niu;
    }

    public void setNiu(@NonNull Integer niu) {
        this.niu = niu;
    }

    @NonNull
    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(@NonNull Integer courseNo) {
        this.courseNo = courseNo;
    }

    @NonNull
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(@NonNull Integer grade) {
        this.grade = grade;
    }
}
