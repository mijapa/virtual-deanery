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

    //TODO Michał pierwsza linijka w przypadku litery rzuci exception i zamknie aplikację, trzeba to poprawić coś na wzór
    //TODO tego co robiłam w attemptLogin() skoro przeniosłeś to tutaj, a z tamtąd wyrzucić ?

    Boolean checkLoginPassword(int niu, String password) {

        Boolean passOK = false;
        String passFromDB = mRepository.getPassword();
        try {
            passOK = passFromDB.equals(password);
        } catch (Exception e) {
            try {
                mRepository.updateStudentData(niu,password);
                passOK = passFromDB.equals(password);
            } catch (Exception e2) {
                passOK = false;
            }
        }
        return passOK;
    }

    public void setNiu(Integer NIU) {
        mRepository.setNiu(NIU);
    }

}
