package com.edu.pk.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.edu.pk.data.Student;
import com.edu.pk.data.StudentApplication;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class WaitingRoomViewModel extends AndroidViewModel {
    private LiveData<List<StudentApplication>> mStudentApplications;
    private VirtualDeaneryRepository mRepository;

    public WaitingRoomViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
        mStudentApplications = mRepository.getStudentApplications();
    }

    public LiveData<List<StudentApplication>> getStudentApplications() {
        return mStudentApplications;
    }
}
