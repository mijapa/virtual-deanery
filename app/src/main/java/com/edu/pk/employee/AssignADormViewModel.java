package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.StudentDormitory;
import com.edu.pk.data.VirtualDeaneryRepository;

public class AssignADormViewModel extends AndroidViewModel {

    VirtualDeaneryRepository mRepository;

    public AssignADormViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void insertStudentDormitory(StudentDormitory studentDormitory){
        mRepository.insertStudentDormitory(studentDormitory);
    }
}