package com.edu.pk.student.dormitory;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.StudentApplication;

public class ReservationsActivity extends BaseActivity {

    private String[] mArrayOfDorms = new String[]{"DS1", "DS2", "DS3", "DS4"};
    private ArrayAdapter<String> mAdapter;
    private Spinner mDorms;
    private Button mApplicationForAReservation;
    private ReservationsViewModel mReservationsViewModel;
    private Toast toast;
    private View view;
    private static Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        mDorms = (Spinner) findViewById(R.id.dorms);
        mApplicationForAReservation = (Button) findViewById(R.id.application_for_a_reservation);
        mReservationsViewModel = ViewModelProviders.of(this).get(ReservationsViewModel.class);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mArrayOfDorms);
        mDorms.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toast = Toast.makeText(getBaseContext(), R.string.application_sent, Toast.LENGTH_LONG);
        view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    public void onClick(View view) {
        if(view.getId() == R.id.application_for_a_reservation){
            String status = mReservationsViewModel.getStatusApplication(mReservationsViewModel.getAlbumNo(), "Wniosek o akademik");
            if(flag == false && status != null && status.contains("zaakceptowany")) {
                StudentApplication studentApplication;
                studentApplication = new StudentApplication(
                        "Wniosek o rezerwację " + mDorms.getSelectedItem().toString(),
                        mReservationsViewModel.getAlbumNo(),
                        mReservationsViewModel.getDistanceFromTheCheck_InPlace(),
                        "oczekujący"
                );
                mReservationsViewModel.insertStudentApplication(studentApplication);
                flag = true;
                toast.show();
            }else{
                toast = Toast.makeText(getBaseContext(), R.string.application_information, Toast.LENGTH_LONG);
                view = toast.getView();
                view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(getResources().getColor(R.color.colorPrimary));
                toast.show();
            }
        }
    }

}
