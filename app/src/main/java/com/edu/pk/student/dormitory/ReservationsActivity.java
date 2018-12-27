package com.edu.pk.student.dormitory;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
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
    private ReservationsViewModel mReservationsViewModel;
    private String mNiu;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        mDorms = (Spinner) findViewById(R.id.dorms);
        mReservationsViewModel = ViewModelProviders.of(this).get(ReservationsViewModel.class);
        mNiu = getIntent().getStringExtra("niu");
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mArrayOfDorms);
        mDorms.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toast = Toast.makeText(getBaseContext(), R.string.application_sent, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));


    }

    public void onClick(View view) {
        if(view.getId() == R.id.application_for_a_reservation){
            StudentApplication studentApplication;
            studentApplication = new StudentApplication(
                    "Wniosek o rezerwację " + mDorms.getSelectedItem().toString(),
                    mReservationsViewModel.getAlbumNo(Integer.parseInt(mNiu)),
                    mReservationsViewModel.getDistanceFromTheCheck_InPlace(Integer.parseInt(mNiu))
            );
            mReservationsViewModel.insertStudentApplication(studentApplication);
            toast.show();
        }
    }

}
