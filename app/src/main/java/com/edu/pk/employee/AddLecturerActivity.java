package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Lecturer;

public class AddLecturerActivity extends BaseActivity {

    private AutoCompleteTextView mNiu;
    private AutoCompleteTextView mPassword;
    private AutoCompleteTextView mFirstName;
    private AutoCompleteTextView mLastName;
    private AutoCompleteTextView mAddress;
    private AutoCompleteTextView mPhoneNumber;
    private AddLecturerViewModel mAddLecturerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lecturer);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu_lecturer);
        mPassword = (AutoCompleteTextView) findViewById(R.id.password_lecturer);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.first_name_lecturer);
        mLastName = (AutoCompleteTextView) findViewById(R.id.last_name_lecturer);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address_lecturer);
        mPhoneNumber = (AutoCompleteTextView) findViewById(R.id.phone_number_lecturer);

        mAddLecturerViewModel = ViewModelProviders.of(this).get(AddLecturerViewModel.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lecturer lecturer;
                lecturer = new Lecturer(
                        Integer.parseInt(mNiu.getText().toString()),
                        mPassword.getText().toString(),
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mAddress.getText().toString(),
                        Integer.parseInt(mPhoneNumber.getText().toString())

                );

                mAddLecturerViewModel.insertLecturer(lecturer);

            }
        });
    }

}