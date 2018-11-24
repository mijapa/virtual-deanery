package com.edu.pk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.button1:
                intent = new Intent(MenuActivity.this, MyDataActivity.class);
                startActivity(intent);
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                intent = new Intent(MenuActivity.this, PasswordChangeActivity.class);
                startActivity(intent);
        }
    }
}
