package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class LoginViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    Boolean checkLoginPassword(int niu, String password) {
        Boolean isPassOK;
        String passFromDB = mRepository.getPassword();
        mRepository.updateData();
        try {
            isPassOK = passFromDB.equals(password);
        } catch (Exception e) {
            try {
                passFromDB = mRepository.getPassword();
                isPassOK = passFromDB.equals(password);
            } catch (Exception e2) {
                isPassOK = false;
            }
        }
        return isPassOK;
    }

    public void setNiu(Integer NIU) {
        mRepository.setNiu(NIU);
    }

}
