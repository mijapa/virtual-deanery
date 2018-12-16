package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface EmployeeDao {

    @Insert
    void insert(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll();

    @Query("SELECT password FROM employee WHERE NIU = :niu")
    String getEmployeePassword(Integer niu);
}
