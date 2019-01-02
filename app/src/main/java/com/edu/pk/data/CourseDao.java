package com.edu.pk.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Course course);

    @Query("DELETE FROM course")
    void deleteAll();

    @Query("SELECT * FROM course")
    LiveData<List<Course>> getCourses();

    @Query("SELECT * FROM course")
    List<Course> getCourseList();

    @Query("SELECT * FROM course NATURAL JOIN lecturer_course WHERE niu =:niu")
    List<Course> getCourseListById(Integer niu);

}
