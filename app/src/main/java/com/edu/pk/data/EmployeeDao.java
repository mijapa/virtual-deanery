package com.edu.pk.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll();

    @Query("SELECT password FROM employee WHERE NIU = :niu")
    String getEmployeePassword(Integer niu);

    @Query("UPDATE employee SET niu = :niu, password = :newPassword WHERE niu = :niu")
    void changePasswordEmployee(Integer niu, String newPassword);

    @Query("SELECT NIU FROM employee WHERE NIU = :niu")
    Integer getEmployeeNiu(Integer niu);

}
