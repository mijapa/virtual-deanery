package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Course;
import com.edu.pk.data.VirtualDeaneryRepository;

public class AddCourseViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddCourseViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertCourse(Course course){
        mRepository.insertCourse(course);
    }
}
