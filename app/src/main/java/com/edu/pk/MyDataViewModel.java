package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

public class MyDataViewModel extends AndroidViewModel {
    private VirtualDeaneryRepository mRepository;
    private LiveData<Student> mStudent;

    public MyDataViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
        mStudent = mRepository.getStudent();
    }

    LiveData<Student> getStudent() {
        return mStudent;
    }
}
