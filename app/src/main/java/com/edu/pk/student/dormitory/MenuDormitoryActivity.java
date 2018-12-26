package com.edu.pk.student.dormitory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

public class MenuDormitoryActivity extends BaseActivity {

    private String mNiu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dormitory);

        mNiu = getIntent().getStringExtra("niu");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.application_for_a_dormitory:
                intent = new Intent(this, ApplicationForADormitoryActivity.class);
                intent.putExtra("niu", mNiu);
                startActivity(intent);
                break;
            case R.id.reservations:
                break;
            case R.id.accommodation:
                break;
            case R.id.history_about_dorms:
                break;
        }
    }

}
