package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "student_dormitory")
public class StudentDormitory {

    @PrimaryKey(autoGenerate = true)
    private Integer studentDormitoryNo;
    @NonNull
    private Integer studentAlbumNo; //TODO zmienić na niu
    @NonNull
    private String dormitory;
    @NonNull
    private String room;

    public StudentDormitory(@NonNull Integer studentAlbumNo, @NonNull String dormitory, @NonNull String room) {
        this.studentAlbumNo = studentAlbumNo;
        this.dormitory = dormitory;
        this.room = room;
    }

    public Integer getStudentDormitoryNo() {
        return studentDormitoryNo;
    }

    public void setStudentDormitoryNo(Integer studentDormitoryNo) {
        this.studentDormitoryNo = studentDormitoryNo;
    }

    @NonNull
    public Integer getStudentAlbumNo() { return studentAlbumNo; }

    @NonNull
    public String getDormitory() { return dormitory; }

    @NonNull
    public String getRoom() { return room; }

}
