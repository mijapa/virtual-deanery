package com.edu.pk.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.edu.pk.data.StudentDormitory;

@Dao
public interface StudentDormitoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(StudentDormitory studentDormitory);

    @Query("SELECT dormitory FROM student_dormitory WHERE studentAlbumNo = :studentAlbumNo")
    String getDorm(Integer studentAlbumNo);

    @Query("SELECT room FROM student_dormitory WHERE studentAlbumNo = :studentAlbumNo")
    String getRoom(Integer studentAlbumNo);

    @Query("DELETE FROM student_dormitory")
    void deleteAll();

}
