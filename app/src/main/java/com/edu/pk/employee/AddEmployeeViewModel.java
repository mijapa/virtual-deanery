package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Employee;
import com.edu.pk.data.VirtualDeaneryRepository;

public class AddEmployeeViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddEmployeeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertEmployee(Employee employee){
        mRepository.insertEmployee(employee);
    }
}