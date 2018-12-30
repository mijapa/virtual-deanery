package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Course;
import com.edu.pk.data.FieldOfStudy;
import com.edu.pk.data.FieldOfStudyCourse;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class AddFieldOfStudyViewModel extends AndroidViewModel {
    VirtualDeaneryRepository mRepository;

    public AddFieldOfStudyViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void insertFieldOfStudy(FieldOfStudy fieldOfStudy){
        mRepository.insertFielfOfStudy(fieldOfStudy);
    }

    void insertFieldOfStudyCourse(FieldOfStudy fieldOfStudy){
        List<Course> courses = mRepository.getCourseList();
        for(Course c: courses){
            if(c.getDepartment().equals(fieldOfStudy.getDepartment()) && c.getFieldOfStudy().equals(fieldOfStudy.getFieldOfStudyName())){
                mRepository.insertFielfOfStudyCourse(new FieldOfStudyCourse(fieldOfStudy.getFieldOfStudyNo(), c.getCourseNo()));
            }
        }
    }

}
