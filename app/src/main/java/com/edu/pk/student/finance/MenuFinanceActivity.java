package com.edu.pk.student.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Benefit;
import com.edu.pk.data.Payment;
import com.edu.pk.student.dormitory.AccomodationActivity;
import com.edu.pk.student.dormitory.ApplicationForADormitoryActivity;
import com.edu.pk.student.dormitory.ReservationsActivity;

public class MenuFinanceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.payments:
                intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);
                break;
            case R.id.benefits:
                intent = new Intent(this, BenefitActivity.class);
                startActivity(intent);
                break;
            case R.id.declaration_of_installments:
                intent = new Intent(this, DeclarationOfInstallmentsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
