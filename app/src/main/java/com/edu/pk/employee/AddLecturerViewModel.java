package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Lecturer;
import com.edu.pk.data.VirtualDeaneryRepository;

public class AddLecturerViewModel extends AndroidViewModel {
    VirtualDeaneryRepository mRepository;

    public AddLecturerViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void insertLecturer(Lecturer lecturer){
        mRepository.insertLecturer(lecturer);
    }
}
