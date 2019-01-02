package com.edu.pk.lecturer;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Course;
import com.edu.pk.data.Student;


public class EnterTheGradeActivity extends BaseActivity {

    private ArrayAdapter<Course> mAdapterCourse;
    private ArrayAdapter<Student> mAdapterStudent;
    private Spinner mCourse;
    private Spinner mStudent;
    private Button mSubmitCourse;
    private EnterTheGradeViewModel mEnterTheGradeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_the_grade);

        mCourse = (Spinner) findViewById(R.id.courses);
        mStudent = (Spinner) findViewById(R.id.students);
        mSubmitCourse = (Button) findViewById(R.id.submit_course);
        mEnterTheGradeViewModel = ViewModelProviders.of(this).get(EnterTheGradeViewModel.class);

        mAdapterCourse = new ArrayAdapter<Course>(getApplicationContext(), R.layout.spinner_item, android.R.id.text1, mEnterTheGradeViewModel.getCourseList()) {
            @Override
            public View getDropDownView(final int position, final View convertView, final ViewGroup parent) {
                final View v = super.getDropDownView(position, convertView, parent);
                v.post(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) v.findViewById(android.R.id.text1)).setSingleLine(false);
                    }
                });
                return v;
            }
        };

        mAdapterCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourse.setAdapter(mAdapterCourse);
        mStudent.setEnabled(false);

        mSubmitCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course course = (Course) mCourse.getSelectedItem();
                mStudent.setEnabled(true);
                mAdapterStudent = new ArrayAdapter<Student>(getApplicationContext(), R.layout.spinner_item, android.R.id.text1, mEnterTheGradeViewModel.getStudentByFieldOfStudyList(course.getFieldOfStudy(), course.getDepartment(), course.getTerm())) {
                    @Override
                    public View getDropDownView(final int position, final View convertView, final ViewGroup parent) {
                        final View v = super.getDropDownView(position, convertView, parent);
                        v.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView) v.findViewById(android.R.id.text1)).setSingleLine(false);
                            }
                        });
                        return v;
                    }
                };
                mAdapterStudent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mStudent.setAdapter(mAdapterStudent);
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
