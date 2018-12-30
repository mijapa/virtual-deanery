package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


@Dao
public interface LecturerCourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(LecturerCourse lecturerCourse);

    @Query("DELETE FROM lecturer_course")
    void deleteAll();
}
