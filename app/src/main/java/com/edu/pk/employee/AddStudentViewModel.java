package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.FieldOfStudy;
import com.edu.pk.data.Student;
import com.edu.pk.data.StudentFieldOfStudy;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class AddStudentViewModel extends AndroidViewModel {

    VirtualDeaneryRepository mRepository;

    public AddStudentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void insertStudent(Student student){
        mRepository.insert(student);
    }

    public List<FieldOfStudy> getFieldOfStudyList() {
        return mRepository.getFieldOfStudyList();
    }

    public void insertStudentFieldOfStudy(StudentFieldOfStudy studentFieldOfStudy) {
        mRepository.insertStudentFieldOfStudy(studentFieldOfStudy);
    }
}
