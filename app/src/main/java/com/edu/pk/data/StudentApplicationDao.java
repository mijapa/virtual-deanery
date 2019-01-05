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

    @Query("SELECT * FROM student_application WHERE status LIKE 'oczekujący'")
    LiveData<List<StudentApplication>> getStudentApplicationsByStatusWaiting();

    @Query("SELECT status FROM student_application WHERE studentAlbumNo = :albumNo AND description = :description")
    String getStatusApplication(Integer albumNo, String description);

    @Query("UPDATE student_application SET status = :status WHERE applicationNo = :applicationNo")
    void setStatusApplication(int applicationNo, String status);

    @Query("DELETE FROM student_application")
    void deleteAll();

}
