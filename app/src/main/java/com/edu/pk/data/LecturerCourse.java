package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "lecturer_course", primaryKeys = {"courseNo", "niu"})
public class LecturerCourse {

    @NonNull
    private Integer courseNo;
    @NonNull
    private Integer niu;

    public LecturerCourse(@NonNull Integer courseNo, @NonNull Integer niu) {
        this.courseNo = courseNo;
        this.niu = niu;
    }

    @NonNull
    public Integer getCourseNo() {
        return courseNo;
    }

    @NonNull
    public Integer getNiu() {
        return niu;
    }

}
