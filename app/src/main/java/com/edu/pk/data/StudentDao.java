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
    LiveData<Student> getStudent(Integer niu);

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

}
