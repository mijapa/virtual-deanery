package com.edu.pk.student.finance;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Benefit;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class BenefitViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public BenefitViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<Benefit> getBenefits(){
        return mRepository.getBenefits();
    }
}
