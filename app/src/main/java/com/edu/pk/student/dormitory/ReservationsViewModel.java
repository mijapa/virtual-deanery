package com.edu.pk.student.dormitory;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.StudentApplication;
import com.edu.pk.data.VirtualDeaneryRepository;

public class ReservationsViewModel extends AndroidViewModel {
    VirtualDeaneryRepository mRepository;

    public ReservationsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }
    Integer getAlbumNo() {
        return mRepository.getAlbumNo();
    }
    Integer getDistanceFromTheCheck_InPlace(){
        return mRepository.getDistanceFromTheCheck_InPlace();
    }
    String getStatusApplication(Integer albumNo, String description){
        return mRepository.getStatusApplication(albumNo, description);
    }
    void insertStudentApplication(StudentApplication studentApplication){
        mRepository.insertStudentApplication(studentApplication);
    }

    public Integer getNiu() {
        return mRepository.getNiu();
    }
}
