package com.edu.pk.employee;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

public class EmployeeMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
