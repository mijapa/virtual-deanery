package com.edu.pk.lecturer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.PasswordChangeActivity;
import com.edu.pk.R;


public class LecturerMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.enter_the_grade:
                intent = new Intent(this, EnterTheGradeActivity.class);
                startActivity(intent);
                break;
            case R.id.change_password_lecturer:
                Bundle bundle = new Bundle();
                bundle.putString("goto", "LecturerMenuActivity");
                intent = new Intent(getApplicationContext(), PasswordChangeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
        }
    }

}
