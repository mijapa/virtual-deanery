package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FieldOfStudyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FieldOfStudy fieldOfStudy);

    @Query("DELETE FROM field_of_study")
    void deleteAll();

    @Query("SELECT * FROM field_of_study")
    List<FieldOfStudy> getFieldOfStudyList();

}
