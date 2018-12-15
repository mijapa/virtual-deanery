package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Student;
import com.edu.pk.data.VirtualDeaneryRepository;

public class AddStudentViewModel extends AndroidViewModel {

    VirtualDeaneryRepository mRepository;

    public AddStudentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void insertStudent(Student student){
        mRepository.insert(student);
    }
}
