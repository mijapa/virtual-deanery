package com.edu.pk.student.timetable;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

public class SyllabusActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
