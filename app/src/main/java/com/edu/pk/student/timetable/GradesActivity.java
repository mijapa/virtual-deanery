package com.edu.pk.student.timetable;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Grade;

import java.util.List;

public class GradesActivity extends BaseActivity {

    private GradesViewModel mGradesViewModel;

    //TODO change data to meaningful.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final GradesAdapter adapter = new GradesAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mGradesViewModel = ViewModelProviders.of(this).get(GradesViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mGradesViewModel.getGrades().observe(this, new Observer<List<Grade>>() {
            @Override
            public void onChanged(@Nullable final List<Grade> grades) {
                // Update the cached copy of the grades in the adapter.
                adapter.setGrades(grades);
            }
        });
    }
}