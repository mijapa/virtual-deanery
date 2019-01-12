package com.edu.pk.lecturer;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Course;
import com.edu.pk.data.Grade;
import com.edu.pk.data.Student;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class EnterTheGradeViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public EnterTheGradeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<Course> getCourseList() { return mRepository.getCourseListById(); }

    public List<Student> getStudentByFieldOfStudyList(String fieldOfStudy, String department, Integer term) { return mRepository.getStudentByFieldOfStudyList(fieldOfStudy, department, term); }

    public void insertGrade(Grade grade) {
        mRepository.insertGrade(grade);
    }
}
