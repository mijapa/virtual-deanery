package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Payment payment);

    @Query("DELETE FROM payment")
    void deleteAll();

    @Query("SELECT * FROM payment WHERE idStudent = :niu")
    List<Payment> getPayments(Integer niu);
}
