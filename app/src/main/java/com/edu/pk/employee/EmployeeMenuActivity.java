package com.edu.pk.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.PasswordChangeActivity;
import com.edu.pk.R;

public class EmployeeMenuActivity extends BaseActivity {

    private String mNiu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);
        mNiu = getIntent().getStringExtra("niu");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.add_student:
                intent = new Intent(this, AddStudentActivity.class);
                startActivity(intent);
                break;
            case R.id.add_lecturer:
                intent = new Intent(this, AddLecturerActivity.class);
                startActivity(intent);
                break;
            case R.id.add_employee:
                intent = new Intent(this, AddEmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.add_course:
                intent = new Intent(this, AddCourseActivity.class);
                startActivity(intent);
                break;
            case R.id.change_password_employee:
                Bundle bundle = new Bundle();
                bundle.putString("goto", "EmployeeMenuActivity");
                intent = new Intent(getApplicationContext(), PasswordChangeActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("niu", mNiu);
                startActivity(intent);
        }
    }
}
