package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface StudentFieldOfStudyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(StudentFieldOfStudy studentFieldOfStudy);

    @Query("DELETE FROM student_field_of_study")
    void deleteAll();

}
