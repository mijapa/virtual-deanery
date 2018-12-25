package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Course;

public class AddCourseActivity extends BaseActivity {

    private AutoCompleteTextView mCourseNo;
    private AutoCompleteTextView mName;
    private AutoCompleteTextView mEcts;
    private AutoCompleteTextView mTerm;
    private AutoCompleteTextView mDepartment;
    private AutoCompleteTextView mHourAmount;
    private AddCourseViewModel mAddCourseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        mCourseNo = (AutoCompleteTextView) findViewById(R.id.course_no);
        mName = (AutoCompleteTextView) findViewById(R.id.course_name);
        mEcts = (AutoCompleteTextView) findViewById(R.id.course_ects);
        mTerm = (AutoCompleteTextView) findViewById(R.id.course_term);
        mDepartment = (AutoCompleteTextView) findViewById(R.id.course_department);
        mHourAmount = (AutoCompleteTextView) findViewById(R.id.course_hour_amount);

        mAddCourseViewModel = ViewModelProviders.of(this).get(AddCourseViewModel.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course course;
                course = new Course(
                        Integer.parseInt(mCourseNo.getText().toString()),
                        mName.getText().toString(),
                        mEcts.getText().toString(),
                        mTerm.getText().toString(),
                        mDepartment.getText().toString(),
                        mHourAmount.getText().toString()

                );
                mAddCourseViewModel.insertCourse(course);
            }
        });
    }
}
