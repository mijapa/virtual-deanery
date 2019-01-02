package com.edu.pk.student.dormitory;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class AccomodationViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AccomodationViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public Integer getAlbumNo(){
        return mRepository.getAlbumNo();
    }

    public String getDorm(Integer albumNo){
        return mRepository.getDorm(albumNo);
    }

    public String getRoom(Integer albumNo){
        return mRepository.getRoom(albumNo);
    }

    public Integer getNiu() {
        return mRepository.getNiu();
    }
}
