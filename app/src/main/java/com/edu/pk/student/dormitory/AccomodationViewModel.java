package com.edu.pk.student.dormitory;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class AccomodationViewModel extends AndroidViewModel {
    VirtualDeaneryRepository mRepository;

    public AccomodationViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    Integer getAlbumNo(){
        return mRepository.getAlbumNo();
    }
    String getDorm(Integer albumNo){
        return mRepository.getDorm(albumNo);
    }
    String getRoom(Integer albumNo){
        return mRepository.getRoom(albumNo);
    }

    public Integer getNiu() {
        return mRepository.getNiu();
    }
}
