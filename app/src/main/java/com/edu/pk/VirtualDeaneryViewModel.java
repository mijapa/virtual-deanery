package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

public class VirtualDeaneryViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public VirtualDeaneryViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);

    }

    public void insert(Student student) {
        mRepository.insert(student);
    }

    LiveData<String> getStudentPassword(Integer NIU) {
        return mRepository.getStudentPassword(NIU);
    }
}
