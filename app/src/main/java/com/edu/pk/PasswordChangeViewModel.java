package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class PasswordChangeViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public PasswordChangeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void changePassword(String newPassword){
        int yourNiu = mRepository.getNiu();
        mRepository.updatePasswordForUser(yourNiu, newPassword);
    }

    public boolean checkCurrentPassword(String currentPassword){
        Boolean passOK = false;
        String passFromDB = mRepository.getPassword();
        try {
            passOK = passFromDB.equals(currentPassword);
        } catch (Exception e) {
            passOK = false;
        }
        return passOK;
    }

    public Integer getNiu() {
        return mRepository.getNiu();
    }
}
