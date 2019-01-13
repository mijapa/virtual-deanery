package com.edu.pk.student.mydata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class EditViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public EditViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void setAddress(String address){ mRepository.setAddress(address); }

    public void setCityOrVillage(String cityOrVillage){ mRepository.setCityOrVillage(cityOrVillage); }

    public void setVoivodeship(String voivodeship){ mRepository.setVoivodeship(voivodeship); }

    public void setOtherNumber(Integer otherNumber){ mRepository.setOtherNumber(otherNumber); }

    public void setEmail(String email){ mRepository.setEmail(email); }

    public void updateStudentData() {
        mRepository.updateStudentData();
    }
}
