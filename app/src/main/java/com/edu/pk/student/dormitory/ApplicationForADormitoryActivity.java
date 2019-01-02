package com.edu.pk.student.dormitory;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.StudentApplication;

import java.util.Calendar;
import java.util.Date;

public class ApplicationForADormitoryActivity extends BaseActivity {

    private TextView mInformation;
    private Button mSubmitApllication;
    private ApplicationForADormitoryViewModel mApplicationForADormitoryViewModel;
    private static String information = "";
    private static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_for_adormitory);

        mInformation = (TextView) findViewById(R.id.information2);
        mSubmitApllication = (Button) findViewById(R.id.submit_an_application);
        mApplicationForADormitoryViewModel = ViewModelProviders.of(this).get(ApplicationForADormitoryViewModel.class);

        mInformation.setText(information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        String status = mApplicationForADormitoryViewModel.getStatusApplication(mApplicationForADormitoryViewModel.getAlbumNo(), "Wniosek o akademik");
        if(status != null && !status.equals("oczekujący")){
            mInformation.setText(status);
        }else
            mInformation.setText(information);

        if(flag == true)
            mSubmitApllication.setEnabled(false);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.submit_an_application){
            StudentApplication studentApplication;
            studentApplication = new StudentApplication(
                    "Wniosek o akademik",
                    mApplicationForADormitoryViewModel.getAlbumNo(),
                    mApplicationForADormitoryViewModel.getDistanceFromTheCheck_InPlace(),
                    "oczekujący"
            );
            mApplicationForADormitoryViewModel.insertStudentApplication(studentApplication);

            mSubmitApllication.setEnabled(false);
            flag = true;
            Date currentTime = Calendar.getInstance().getTime();
            information = "Wniosek został wysłany: " + currentTime;
            mInformation.setText(information);
        }
    }

}
