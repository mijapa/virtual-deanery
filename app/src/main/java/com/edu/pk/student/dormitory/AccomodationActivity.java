package com.edu.pk.student.dormitory;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.edu.pk.R;

public class AccomodationActivity extends AppCompatActivity {

    private TextView mWhichDorm;
    private TextView mWhichRoom;
    private String mNiu;
    private AccomodationViewModel mAccomodationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);

        mWhichDorm = (TextView) findViewById(R.id.which_dorm);
        mWhichRoom = (TextView) findViewById(R.id.which_room);
        mNiu =  getIntent().getStringExtra("niu");
        mAccomodationViewModel = ViewModelProviders.of(this).get(AccomodationViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        int albumNo = mAccomodationViewModel.getAlbumNo(Integer.parseInt(mNiu));
        mWhichDorm.setText(mAccomodationViewModel.getDorm(albumNo));
        mWhichRoom.setText(mAccomodationViewModel.getRoom(albumNo));
    }


}
