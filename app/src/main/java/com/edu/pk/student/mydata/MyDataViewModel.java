package com.edu.pk.student.mydata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.edu.pk.data.Student;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class MyDataViewModel extends AndroidViewModel {
    private LiveData<List<Student>> mStudents;
    private VirtualDeaneryRepository mRepository;

    public MyDataViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
        mStudents = mRepository.getStudents();
    }

    public LiveData<List<Student>> getStudents() {
        return mStudents;
    }
}
