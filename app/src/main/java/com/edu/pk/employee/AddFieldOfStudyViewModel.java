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

    private VirtualDeaneryRepository mRepository;

    public AddFieldOfStudyViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertFieldOfStudy(FieldOfStudy fieldOfStudy){ mRepository.insertFieldOfStudy(fieldOfStudy); }

    public void insertFieldOfStudyCourse(FieldOfStudy fieldOfStudy){
        List<Course> courses = mRepository.getCourseList();
        for(Course c: courses){
            if(c.getDepartment().equals(fieldOfStudy.getDepartment()) && c.getFieldOfStudy().equals(fieldOfStudy.getFieldOfStudyName())){
                mRepository.insertFieldOfStudyCourse(new FieldOfStudyCourse(fieldOfStudy.getFieldOfStudyNo(), c.getCourseNo()));
            }
        }
    }

}
