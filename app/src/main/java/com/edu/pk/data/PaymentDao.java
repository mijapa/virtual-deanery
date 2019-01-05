package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Payment payment);

    @Query("DELETE FROM payment")
    void deleteAll();

}
