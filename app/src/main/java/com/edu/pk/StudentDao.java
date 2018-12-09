package com.edu.pk;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insert(Student student);

    @Query("DELETE FROM student")
    void deleteAll();

    @Query("SELECT NIU FROM student")
    List<Integer> getAllNIU();

    //    @Query("SELECT * FROM student where NIU = :niu")
//    Student getStudent(Integer niu);
//
    @Query("SELECT password FROM student where NIU = :niu")
    LiveData<String> getStudentPassword(Integer niu);
}
