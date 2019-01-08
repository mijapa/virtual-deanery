package com.edu.pk.student.finance;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pk.data.Payment;
import com.edu.pk.data.VirtualDeaneryRepository;

import java.util.List;

public class PaymentViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public PaymentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<Payment> getPayments(){
        return mRepository.getPayments();
    }
}
