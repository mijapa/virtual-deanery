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
    private String term;
    @NonNull
    private String department;
    @NonNull
    private String hourAmount;

    public Course(@NonNull Integer courseNo, @NonNull String name, @NonNull String ects, @NonNull String term, @NonNull String department, @NonNull String hourAmount) {
        this.courseNo = courseNo;
        this.name = name;
        this.ects = ects;
        this.term = term;
        this.department = department;
        this.hourAmount = hourAmount;
    }

    @NonNull
    public Integer getCourseNo() { return courseNo; }

    @NonNull
    public String getName() { return name; }

    @NonNull
    public String getEcts() { return ects; }

    @NonNull
    public String getTerm() { return term; }

    @NonNull
    public String getDepartment() { return department; }

    @NonNull
    public String getHourAmount() { return hourAmount; }

    @Override
    public String toString() {
        return  getDepartment() + " " + getTerm() + " " + getName();
    }
}
