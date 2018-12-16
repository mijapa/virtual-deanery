package com.edu.pk.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey
    @NonNull
    private Integer NIU;
    @NonNull
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String cityOrVillage;
    @NonNull
    private String pesel;
    @NonNull
    private String email;

    public Employee(@NonNull Integer NIU, @NonNull String password, @NonNull String firstName, @NonNull String lastName, @NonNull String address, @NonNull String cityOrVillage, @NonNull String pesel, @NonNull String email) {
        this.NIU = NIU;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cityOrVillage = cityOrVillage;
        this.pesel = pesel;
        this.email = email;
    }

    @NonNull
    public Integer getNIU() {
        return NIU;
    }

    @NonNull
    public String getPassword() { return password; }

    @NonNull
    public String getFirstName() { return firstName; }

    @NonNull
    public String getLastName() { return lastName; }

    @NonNull
    public String getAddress() { return address; }

    @NonNull
    public String getCityOrVillage() { return cityOrVillage; }

    @NonNull
    public String getPesel() { return pesel; }

    @NonNull
    public String getEmail() { return email; }
}
