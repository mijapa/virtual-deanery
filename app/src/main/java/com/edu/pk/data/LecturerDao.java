package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface LecturerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Lecturer lecturer);

    @Query("DELETE FROM lecturer")
    void deleteAll();

    @Query("SELECT password FROM lecturer where niu = :niu")
    String getLecturerPassword(Integer niu);
}