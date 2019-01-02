package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Course;
import com.edu.pk.data.Lecturer;
import com.edu.pk.data.LecturerCourse;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class AddLecturerViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddLecturerViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertLecturer(Lecturer lecturer) { mRepository.insertLecturer(lecturer); }

    public List<Course> getCourseList() {
        return mRepository.getCourseList();
    }

    public void insertLecturerCourse(LecturerCourse lecturerCourse) { mRepository.insertLecturerCourse(lecturerCourse); }
}
