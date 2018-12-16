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
        String passFromDB = mRepository.getStudentPassword(NIU);
        String passFromEmployeeDB = mRepository.getEmployeePassword(email);
        try {
            Boolean pom = new Boolean(passFromDB.equals(password));
        }catch(Exception e){
            try{
                Boolean pom = new Boolean(passFromEmployeeDB.equals(password));
                return true;
            }catch(Exception ee){
                return false;
            }
        }
        return true;
    }

    public Integer getNIU() {
        return mRepository.getNIU();
    }

    public void setNIU(Integer NIU) {
        mRepository.setNIU(NIU);
    }
}
