package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "course")
public class Course {

    @PrimaryKey
    @NonNull
    private Integer courseNo;
    @NonNull
    private String name;
    @NonNull
    private String ects;
    @NonNull
    private Integer term;
    @NonNull
    private String department;
    @NonNull
    private String fieldOfStudy;
    @NonNull
    private String hourAmount;

    public Course(@NonNull Integer courseNo, @NonNull String name, @NonNull String ects, @NonNull Integer term, @NonNull String department, @NonNull String fieldOfStudy, @NonNull String hourAmount) {
        this.courseNo = courseNo;
        this.name = name;
        this.ects = ects;
        this.term = term;
        this.department = department;
        this.fieldOfStudy = fieldOfStudy;
        this.hourAmount = hourAmount;
    }

    @NonNull
    public Integer getCourseNo() { return courseNo; }

    @NonNull
    public String getName() { return name; }

    @NonNull
    public String getEcts() { return ects; }

    @NonNull
    public Integer getTerm() { return term; }

    @NonNull
    public String getDepartment() { return department; }

    @NonNull
    public String getFieldOfStudy() { return fieldOfStudy; }

    @NonNull
    public String getHourAmount() { return hourAmount; }

    @Override
    public String toString() {
        return  getDepartment() + " " + getTerm() + " " + getName();
    }
}
