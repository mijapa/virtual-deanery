package com.edu.pk.student.dormitory;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.StudentApplication;
import com.edu.pk.data.VirtualDeaneryRepository;

public class ApplicationForADormitoryViewModel extends AndroidViewModel {
    VirtualDeaneryRepository mRepository;

    public ApplicationForADormitoryViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }
    Integer getAlbumNo() {
        return mRepository.getAlbumNo();
    }
    Integer getDistanceFromTheCheck_InPlace(){
        return mRepository.getDistanceFromTheCheck_InPlace();
    }
    void insertStudentApplication(StudentApplication studentApplication){
        mRepository.insertStudentApplication(studentApplication);
    }
    String getStatusApplication(Integer albumNo, String description){
        return mRepository.getStatusApplication(albumNo, description);
    }
}
