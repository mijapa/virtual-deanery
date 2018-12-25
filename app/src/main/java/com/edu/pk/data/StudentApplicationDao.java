package com.edu.pk.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentApplicationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(StudentApplication studentApplication);

    @Query("SELECT * FROM student_application")
    LiveData<List<StudentApplication>> getStudentApplications();
}
