package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "lecturer")
public class Lecturer {

    @PrimaryKey
    @NonNull
    private Integer niu;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private Integer phoneNumber;

    public Lecturer(@NonNull Integer niu, @NonNull String password, @NonNull String firstName, @NonNull String lastName, @NonNull String address, @NonNull Integer phoneNumber) {
        this.niu = niu;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public Integer getNiu() { return niu; }

    @NonNull
    public String getPassword() { return password; }

    @NonNull
    public String getFirstName() { return firstName; }

    @NonNull
    public String getLastName() { return lastName; }

    @NonNull
    public String getAddress() { return address; }

    @NonNull
    public Integer getPhoneNumber(){ return phoneNumber; }
}