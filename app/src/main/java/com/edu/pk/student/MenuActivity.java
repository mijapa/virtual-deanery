package com.edu.pk.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.PasswordChangeActivity;
import com.edu.pk.R;
import com.edu.pk.student.dormitory.MenuDormitoryActivity;
import com.edu.pk.student.mydata.MyDataActivity;

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
                intent = new Intent(MenuActivity.this, MenuDormitoryActivity.class);
                startActivity(intent);
                break;
            case R.id.button6:
                Bundle bundle = new Bundle();
                bundle.putString("goto", "MenuActivity");
                intent = new Intent(getApplicationContext(), PasswordChangeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
        }
    }
}
