package com.edu.pk.student.dormitory;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

import java.util.Calendar;
import java.util.Date;

public class ApplicationForADormitory extends BaseActivity {

    private TextView mInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_for_adormitory);

        mInformation = (TextView) findViewById(R.id.information2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onClick(View view) {
        if(view.getId() == R.id.submit_an_application){
            Date currentTime = Calendar.getInstance().getTime();
            mInformation.setText("Wniosek został wysłany: " + currentTime);
        }
    }
}
