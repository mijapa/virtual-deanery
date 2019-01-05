package com.edu.pk.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    @Query("DELETE FROM student")
    void deleteAll();

    @Query("SELECT * FROM student where niu = :niu")
    Student getStudent(Integer niu);

    @Query("SELECT password FROM student where niu = :niu")
    String getStudentPassword(Integer niu);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> getStudents();

    @Query("UPDATE student SET niu = :niu, password = :newPassword WHERE niu = :niu")
    void changePasswordStudent(Integer niu, String newPassword);

    @Query("SELECT albumNo FROM student where niu = :niu")
    Integer getAlbumNo(Integer niu);

    @Query("SELECT distanceFromTheCheck_InPlace FROM student where niu = :niu")
    Integer getDistanceFromTheCheck_InPlace(Integer niu);

    @Query("SELECT * FROM student NATURAL JOIN student_field_of_study NATURAL JOIN field_of_study WHERE fieldOfStudyName = :fieldOfStudy AND department = :department AND term = :term")
    List<Student> getStudentByFieldOfStudyList(String fieldOfStudy, String department, Integer term);

    @Query("UPDATE student SET albumNo = :albumNo WHERE niu = :niu")
    void setAlbumNo(Integer niu, Integer albumNo);

    @Query("UPDATE student SET pesel = :pesel WHERE niu = :niu")
    void setPesel(Integer niu, String pesel);

    @Query("UPDATE student SET firstName = :firstName WHERE niu = :niu")
    void setFirstName(Integer niu, String firstName);

    @Query("UPDATE student SET lastName = :lastName WHERE niu = :niu")
    void setLastName(Integer niu, String lastName);

    @Query("UPDATE student SET familyName = :familyName WHERE niu = :niu")
    void setFamilyName(Integer niu, String familyName);

    @Query("UPDATE student SET sex = :sex WHERE niu = :niu")
    void setSex(Integer niu, Integer sex);

    @Query("UPDATE student SET address = :address WHERE niu = :niu")
    void setAddress(Integer niu, String address);

    @Query("UPDATE student SET cityOrVillage = :cityOrVillage WHERE niu = :niu")
    void setCityOrVillage(Integer niu, String cityOrVillage);

    @Query("UPDATE student SET voivodeship = :voivodeship WHERE niu = :niu")
    void setVoivodeship(Integer niu, String voivodeship);

    @Query("UPDATE student SET country = :country WHERE niu = :niu")
    void setCountry(Integer niu, String country);

    @Query("UPDATE student SET distanceFromTheCheck_InPlace = :distanceFromTheCheck_InPlace WHERE niu = :niu")
    void setDistanceFromTheCheck_InPlace(Integer niu, Integer distanceFromTheCheck_InPlace);

    @Query("UPDATE student SET dateOfBirth = :dateOfBirth WHERE niu = :niu")
    void setDateOfBirth(Integer niu, String dateOfBirth);

    @Query("UPDATE student SET placeOfBirth = :placeOfBirth WHERE niu = :niu")
    void setPlaceOfBirth(Integer niu, String placeOfBirth);

    @Query("UPDATE student SET fatherName = :fatherName WHERE niu = :niu")
    void setFatherName(Integer niu, String fatherName);

    @Query("UPDATE student SET motherName = :motherName WHERE niu = :niu")
    void setMotherName(Integer niu, String motherName);

    @Query("UPDATE student SET motherFamilyName = :motherFamilyName WHERE niu = :niu")
    void setMotherFamilyName(Integer niu, String motherFamilyName);

    @Query("UPDATE student SET maritalStatus = :maritalStatus WHERE niu = :niu")
    void setMaritalStatus(Integer niu, Integer maritalStatus);

    @Query("UPDATE student SET foreigner = :foreigner WHERE niu = :niu")
    void setForeigner(Integer niu, Integer foreigner);

    @Query("UPDATE student SET phoneNumber = :phoneNumber WHERE niu = :niu")
    void setPhoneNumber(Integer niu, Integer phoneNumber);

    @Query("UPDATE student SET otherNumber = :otherNumber WHERE niu = :niu")
    void setOtherNumber(Integer niu, Integer otherNumber);

    @Query("UPDATE student SET bankAccount = :bankAccount WHERE niu = :niu")
    void setBankAccount(Integer niu, String bankAccount);

    @Query("UPDATE student SET email = :email WHERE niu = :niu")
    void setEmail(Integer niu, String email);

    @Query("UPDATE student SET dateOfStudyStart = :dateOfStudyStart WHERE niu = :niu")
    void setDateOfStudyStart(Integer niu, String dateOfStudyStart);

    @Query("UPDATE student SET term = :term WHERE niu = :niu")
    void setTerm(Integer niu, Integer term);

}
