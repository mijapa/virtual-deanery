package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class LoginViewModel extends AndroidViewModel {
    private VirtualDeaneryRepository mRepository;
    private String DEBUG_TAG = "DEBUG_TAG";

    public LoginViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    Boolean checkLoginPassword(String email, String password) {
        Integer NIU = Integer.valueOf(email);
        Boolean passOK = false;
        if (NIU < 10) {//student
            String passFromDB = mRepository.getStudentPassword(NIU);
            try {
                passOK = passFromDB.equals(password);
            } catch (Exception e) {
                passOK = false;
            }
        } else {//employee
            String passFromDB = mRepository.getEmployeePassword(NIU);
            try {
                passOK = passFromDB.equals(password);
            } catch (Exception e) {
                passOK = false;
            }
        }
        return passOK;
    }

    public Integer getNIU() {
        return mRepository.getNIU();
    }

    public void setNIU(Integer NIU) {
        mRepository.setNIU(NIU);
    }
}
