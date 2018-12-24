package com.edu.pk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.VirtualDeaneryRepository;

public class PasswordChangeViewModel extends AndroidViewModel {
    VirtualDeaneryRepository mRepository;

    public PasswordChangeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    void changePassword(String niu, String newPassword){
        int yourNiu = Integer.parseInt(niu);
        if (yourNiu < 10) {
            mRepository.changePasswordStudent(yourNiu, newPassword);
        } else if(yourNiu >= 10 && yourNiu < 20) {
            mRepository.changePasswordEmployee(yourNiu, newPassword);
        }else {

        }
    }

    public boolean checkCurrentPassword(String niu, String currentPassword){
        Integer NIU = Integer.valueOf(niu);
        Boolean passOK = false;
        if (NIU < 10) {
            String passFromDB = mRepository.getStudentPassword(NIU);
            try {
                passOK = passFromDB.equals(currentPassword);
            } catch (Exception e) {
                passOK = false;
            }
        } else if(NIU >= 10 && NIU < 20) {
            String passFromDB = mRepository.getEmployeePassword(NIU);
            try {
                passOK = passFromDB.equals(currentPassword);
            } catch (Exception e) {
                passOK = false;
            }
        }else{
            String passFromDB = mRepository.getLecturerPassword(NIU);
            try {
                passOK = passFromDB.equals(currentPassword);
            } catch (Exception e) {
                passOK = false;
            }
        }
        return passOK;
    }
}
