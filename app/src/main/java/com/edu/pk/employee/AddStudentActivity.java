package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Student;

public class AddStudentActivity extends BaseActivity {

    private AddStudentViewModel mAddStudentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        mAddStudentViewModel = ViewModelProviders.of(this).get(AddStudentViewModel.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student;
                student = new Student(
                        4,
                        202020,
                        "4",
                        0,
                        "58082907355",
                        "Michael",
                        "Jackson",
                        "",
                        0,
                        "all hotels :)",
                        "Gary",
                        "Indiana",
                        "USA",
                        3000,
                        "580829",
                        "Gary",
                        "Joseph",
                        "Katherine",
                        "",
                        1,
                        1,
                        600600600,
                        601601601,
                        "66623299949821000000065",
                        "kingofpop@kingofpop.pl",
                        "20160904"
                );

                mAddStudentViewModel.insertStudent(student);

            }
        });
    }
}
