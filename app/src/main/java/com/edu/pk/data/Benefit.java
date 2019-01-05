package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "benefit")
public class Benefit {

    @PrimaryKey
    @NonNull
    private Integer idBenefit;
    @NonNull
    private Integer idStudent;
    @NonNull
    private String nameBenefit;
    @NonNull
    private String sum;
    @NonNull
    private String status;
    @NonNull
    private String fromTheDateOf;
    @NonNull
    private String untilTheDate;

    public Benefit(@NonNull Integer idBenefit, @NonNull Integer idStudent, @NonNull String nameBenefit, @NonNull String sum, @NonNull String status, @NonNull String fromTheDateOf, @NonNull String untilTheDate) {
        this.idBenefit = idBenefit;
        this.idStudent = idStudent;
        this.nameBenefit = nameBenefit;
        this.sum = sum;
        this.status = status;
        this.fromTheDateOf = fromTheDateOf;
        this.untilTheDate = untilTheDate;
    }

    @NonNull
    public Integer getIdBenefit() { return idBenefit; }

    @NonNull
    public Integer getIdStudent() { return idStudent; }

    @NonNull
    public String getNameBenefit() { return nameBenefit; }

    @NonNull
    public String getSum() { return sum; }

    @NonNull
    public String getStatus() { return status; }

    @NonNull
    public String getFromTheDateOf() { return fromTheDateOf; }

    @NonNull
    public String getUntilTheDate() { return untilTheDate; }

}
