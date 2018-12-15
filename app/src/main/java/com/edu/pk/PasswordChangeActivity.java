package com.edu.pk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.employee.EmployeeMenuActivity;
import com.edu.pk.student.MenuActivity;

public class PasswordChangeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void onBackPressed(){
        finish();
    }

    public Intent getSupportParentActivityIntent(){
        return getParentActivityIntentImplement();
    }

    public Intent getParentActivityIntent(){
        return getParentActivityIntentImplement();
    }

    private Intent getParentActivityIntentImplement() {
        Intent intent = null;

        Bundle extras = getIntent().getExtras();
        String goToIntent = extras.getString("goto");

        if(goToIntent.equals("MenuActivity")){
            intent = new Intent(this, MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }else{
            intent = new Intent(this, EmployeeMenuActivity.class);
        }
        return intent;
    }

}
