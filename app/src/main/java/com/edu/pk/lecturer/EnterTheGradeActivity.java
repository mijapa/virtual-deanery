package com.edu.pk.lecturer;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Course;
import com.edu.pk.data.LecturerCourse;
import com.edu.pk.employee.AddLecturerViewModel;


public class EnterTheGradeActivity extends BaseActivity {

    private ArrayAdapter<Course> mAdapter;
    private Spinner mCourse;
    private EnterTheGradeViewModel mEnterTheGradeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_the_grade);

        mCourse = (Spinner) findViewById(R.id.courses);
        mEnterTheGradeViewModel = ViewModelProviders.of(this).get(EnterTheGradeViewModel.class);

        mAdapter = new ArrayAdapter<Course>(getApplicationContext(), R.layout.spinner_item, android.R.id.text1, mEnterTheGradeViewModel.getCourseList())
        {
            @Override
            public View getDropDownView(final int position,final View convertView,final ViewGroup parent)
            {
                final View v=super.getDropDownView(position,convertView,parent);
                v.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ((TextView)v.findViewById(android.R.id.text1)).setSingleLine(false);
                    }
                });
                return v;
            }
        };
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourse.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
