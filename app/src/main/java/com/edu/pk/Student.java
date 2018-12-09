package com.edu.pk;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey
    @NonNull
    private Integer NIU;
    private Integer albumNo;
    private String password;
    private Integer typeAcc;
    private String pesel;
    private String firstName;
    private String lastName;
    private String familyName;
    private Integer sex; //boolean??
    private String address;
    private String cityOrVillage;
    private String voivodeship;
    private String country;
    private Integer distanceFromTheCheck_InPlace;
    private String dateOfBirth; //date??
    private String placeOfBirth;
    private String fatherName;
    private String motherName;
    private String motherFamilyName;
    private Integer maritalStatus; //boolean??
    private Integer foreigner; //boolean??
    private Integer phoneNumber;
    private Integer otherNumber;
    private String bankAccount;
    private String email;
    private String dateOfStudyStart; //date??

    public Student(Integer NIU, Integer albumNo, String password, Integer typeAcc, String pesel, String firstName, String lastName, String familyName, Integer sex, String address, String cityOrVillage, String voivodeship, String country, Integer distanceFromTheCheck_InPlace, String dateOfBirth, String placeOfBirth, String fatherName, String motherName, String motherFamilyName, Integer maritalStatus, Integer foreigner, Integer phoneNumber, Integer otherNumber, String bankAccount, String email, String dateOfStudyStart) {
        this.NIU = NIU;
        this.albumNo = albumNo;
        this.password = password;
        this.typeAcc = typeAcc;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.familyName = familyName;
        this.sex = sex;
        this.address = address;
        this.cityOrVillage = cityOrVillage;
        this.voivodeship = voivodeship;
        this.country = country;
        this.distanceFromTheCheck_InPlace = distanceFromTheCheck_InPlace;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.motherFamilyName = motherFamilyName;
        this.maritalStatus = maritalStatus;
        this.foreigner = foreigner;
        this.phoneNumber = phoneNumber;
        this.otherNumber = otherNumber;
        this.bankAccount = bankAccount;
        this.email = email;
        this.dateOfStudyStart = dateOfStudyStart;
    }

    public Integer getNIU() {
        return NIU;
    }

    public Integer getAlbumNo() {
        return albumNo;
    }

    public String getPassword() {
        return password;
    }

    public Integer getTypeAcc() {
        return typeAcc;
    }

    public String getPesel() {
        return pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Integer getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public String getCountry() {
        return country;
    }

    public Integer getDistanceFromTheCheck_InPlace() {
        return distanceFromTheCheck_InPlace;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMotherFamilyName() {
        return motherFamilyName;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public Integer getForeigner() {
        return foreigner;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getOtherNumber() {
        return otherNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfStudyStart() {
        return dateOfStudyStart;
    }
}
