package com.edu.pk.student.timetable;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.edu.pk.data.Course;
import com.edu.pk.data.Grade;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class GradesViewModel extends AndroidViewModel {
    private final List<Course> mCourses;
    private LiveData<List<Grade>> mGrades;
    private VirtualDeaneryRepository mRepository;

    public GradesViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
        mGrades = mRepository.getGrades();
        mCourses = mRepository.getCourseList();
    }

    public LiveData<List<Grade>> getGrades() {
        return mGrades;
    }

    public List<Course> getCourseList() {
        return mCourses;
    }
}