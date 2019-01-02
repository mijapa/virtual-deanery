package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.StudentDormitory;
import com.edu.pk.data.VirtualDeaneryRepository;

public class AssignADormViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AssignADormViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertStudentDormitory(StudentDormitory studentDormitory){ mRepository.insertStudentDormitory(studentDormitory); }

    public void setStatusApplication(int applicationNo, String status){ mRepository.setStatusApplication(applicationNo, status); }

}