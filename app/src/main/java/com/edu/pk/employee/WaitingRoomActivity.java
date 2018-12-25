package com.edu.pk.employee;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.R;
import com.edu.pk.data.Student;
import com.edu.pk.data.StudentApplication;
import com.edu.pk.student.mydata.MyDataAdapter;
import com.edu.pk.student.mydata.MyDataViewModel;

import java.util.List;

public class WaitingRoomActivity extends AppCompatActivity {

    private WaitingRoomViewModel mWaitingRoomViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WaitingRoomAdapter adapter = new WaitingRoomAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWaitingRoomViewModel = ViewModelProviders.of(this).get(WaitingRoomViewModel.class);
        mWaitingRoomViewModel.getStudentApplications().observe(this, new Observer<List<StudentApplication>>() {
            @Override
            public void onChanged(@Nullable final List<StudentApplication> studentApplications) {
                adapter.setWords(studentApplications);
            }
        });
    }

}
