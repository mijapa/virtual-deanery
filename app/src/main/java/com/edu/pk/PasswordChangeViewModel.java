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

    void changePassword(String niu, String password, String currentPassword, String newPassword, String repeatPassword){
        if(password.equals(currentPassword) && newPassword.equals(repeatPassword)){
            int yourNiu = Integer.parseInt(niu);
            if (yourNiu < 10) {
                mRepository.changePasswordStudent(yourNiu, newPassword);
            } else if(yourNiu >= 10 && yourNiu < 20) {
                mRepository.changePasswordEmployee(yourNiu, newPassword);
            }else{
            }
        }
    }
}
