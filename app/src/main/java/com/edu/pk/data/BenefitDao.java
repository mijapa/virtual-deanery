package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface BenefitDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Benefit benefit);

    @Query("DELETE FROM benefit")
    void deleteAll();

}
