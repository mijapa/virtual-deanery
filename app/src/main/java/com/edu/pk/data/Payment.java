package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "payment")
public class Payment {

    @PrimaryKey
    @NonNull
    private Integer id_payment;
    @NonNull
    private Integer id_student;
    @NonNull
    private String description;
    @NonNull
    private String year;
    @NonNull
    private String termNo;
    @NonNull
    private String term;
    @NonNull
    private String charge;
    @NonNull
    private String accruedInterest;
    @NonNull
    private String estimatedInterest;
    @NonNull
    private String paymentDeadline;
    @NonNull
    private String payment;
    @NonNull
    private String interestPaid;
    @NonNull
    private String toPay;
    @NonNull
    private String comments;

    public Payment(@NonNull Integer id_payment, @NonNull Integer id_student, @NonNull String description, @NonNull String year, @NonNull String termNo, @NonNull String term, @NonNull String charge, @NonNull String accruedInterest, @NonNull String estimatedInterest, @NonNull String paymentDeadline, @NonNull String payment, @NonNull String interestPaid, @NonNull String toPay, @NonNull String comments) {
        this.id_payment = id_payment;
        this.id_student = id_student;
        this.description = description;
        this.year = year;
        this.termNo = termNo;
        this.term = term;
        this.charge = charge;
        this.accruedInterest = accruedInterest;
        this.estimatedInterest = estimatedInterest;
        this.paymentDeadline = paymentDeadline;
        this.payment = payment;
        this.interestPaid = interestPaid;
        this.toPay = toPay;
        this.comments = comments;
    }

    @NonNull
    public Integer getId_payment() { return id_payment; }

    @NonNull
    public Integer getId_student() { return id_student; }

    @NonNull
    public String getDescription() { return description; }

    @NonNull
    public String getYear() { return year; }

    @NonNull
    public String getTermNo() { return termNo; }

    @NonNull
    public String getTerm() { return term; }

    @NonNull
    public String getCharge() { return charge; }

    @NonNull
    public String getAccruedInterest() { return accruedInterest; }

    @NonNull
    public String getEstimatedInterest() { return estimatedInterest; }

    @NonNull
    public String getPaymentDeadline() { return paymentDeadline; }

    @NonNull
    public String getPayment() { return payment; }

    @NonNull
    public String getInterestPaid() { return interestPaid; }

    @NonNull
    public String getToPay() { return toPay; }

    @NonNull
    public String getComments() { return comments; }

}