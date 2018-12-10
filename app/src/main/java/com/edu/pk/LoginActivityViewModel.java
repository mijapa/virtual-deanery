package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class LoginActivityViewModel extends AndroidViewModel {
    private VirtualDeaneryRepository mRepository;
    private String DEBUG_TAG = "DEBUG_TAG";

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    Boolean checkLoginPassword(String email, String password) {
        Integer NIU = Integer.valueOf(email);
        String passFromDB = mRepository.getStudentPassword(NIU);
        if (passFromDB.equals(password))
            return true;
        return false;
    }

    public Integer getNIU() {
        return mRepository.getNIU();
    }

    public void setNIU(Integer NIU) {
        mRepository.setNIU(NIU);
    }
}
