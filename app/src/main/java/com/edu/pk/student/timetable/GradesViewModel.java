package com.edu.pk.student.timetable;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.edu.pk.data.Grade;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class GradesViewModel extends AndroidViewModel {
    private LiveData<List<Grade>> mGrades;
    private VirtualDeaneryRepository mRepository;

    public GradesViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
        mGrades = mRepository.getGrades();
    }

    public LiveData<List<Grade>> getGrades() {
        return mGrades;
    }
}