package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface DecisionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Decision decision);

    @Query("UPDATE decision SET status = :status WHERE applicationNo = :applicationNo")
    void setStatusDecision(int applicationNo, String status);

    @Query("SELECT status FROM decision WHERE studentAlbumNo = :albumNo")
    String getStatusDecision(Integer albumNo);

    @Query("DELETE FROM decision")
    void deleteAll();
}
