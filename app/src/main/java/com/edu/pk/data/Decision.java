package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "decision")
public class Decision {

    @PrimaryKey(autoGenerate = true)
    private Integer decisionNo;
    @NonNull
    private Integer applicationNo;
    @NonNull
    private String description;
    @NonNull
    private Integer studentAlbumNo;
    @NonNull
    private Integer distanceFromTheCheck_InPlace;
    @NonNull
    private String status;

    public Decision(@NonNull Integer applicationNo, @NonNull String description, @NonNull Integer studentAlbumNo, @NonNull Integer distanceFromTheCheck_InPlace, @NonNull String status) {
        this.applicationNo = applicationNo;
        this.description = description;
        this.studentAlbumNo = studentAlbumNo;
        this.distanceFromTheCheck_InPlace = distanceFromTheCheck_InPlace;
        this.status = status;
    }

    public Integer getDecisionNo() {
        return decisionNo;
    }

    @NonNull
    public Integer getApplicationNo() {
        return applicationNo;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public Integer getStudentAlbumNo() {
        return studentAlbumNo;
    }

    @NonNull
    public Integer getDistanceFromTheCheck_InPlace() {
        return distanceFromTheCheck_InPlace;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setDecisionNo(Integer decisionNo) {
        this.decisionNo = decisionNo;
    }
    public void setStatus(@NonNull String status) {
        this.status = status;
    }
}

