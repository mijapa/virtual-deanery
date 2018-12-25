package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "student_application")
public class StudentApplication {

    @PrimaryKey
    @NonNull
    private Integer appliactionNo;
    @NonNull
    private String description;
    @NonNull
    private String studentAlbumNo;
    @NonNull
    private String distanceFromTheCheck_InPlace;
    @NonNull
    private String status;

    public StudentApplication(@NonNull Integer appliactionNo, @NonNull String description, @NonNull String studentAlbumNo, @NonNull String distanceFromTheCheck_InPlace, @NonNull String status) {
        this.appliactionNo = appliactionNo;
        this.description = description;
        this.studentAlbumNo = studentAlbumNo;
        this.distanceFromTheCheck_InPlace = distanceFromTheCheck_InPlace;
        this.status = status;
    }

    @NonNull
    public Integer getAppliactionNo() { return appliactionNo; }

    @NonNull
    public String getDescription() { return description; }

    @NonNull
    public String getStudentAlbumNo() { return studentAlbumNo; }

    @NonNull
    public String getDistanceFromTheCheck_InPlace() { return distanceFromTheCheck_InPlace; }

    @NonNull
    public String getStatus() { return status; }
}
