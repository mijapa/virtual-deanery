package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Employee;

public class AddEmployeeActivity extends BaseActivity {

    private AutoCompleteTextView mNiu;
    private AutoCompleteTextView mPassword;
    private AutoCompleteTextView mFirstName;
    private AutoCompleteTextView mLastName;
    private AutoCompleteTextView mAddress;
    private AutoCompleteTextView mCityOrVillage;
    private AutoCompleteTextView mPesel;
    private AutoCompleteTextView mEmail;
    private AddEmployeeViewModel mAddEmployeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu_employee);
        mPassword = (AutoCompleteTextView) findViewById(R.id.password_employee);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.first_name_employee);
        mLastName = (AutoCompleteTextView) findViewById(R.id.last_name_employee);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address_employee);
        mCityOrVillage = (AutoCompleteTextView) findViewById(R.id.city_or_village_employee);
        mPesel = (AutoCompleteTextView) findViewById(R.id.pesel_employee);
        mEmail = (AutoCompleteTextView) findViewById(R.id.email_employee);

        mAddEmployeeViewModel = ViewModelProviders.of(this).get(AddEmployeeViewModel.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee;
                employee = new Employee(
                        Integer.parseInt(mNiu.getText().toString()),
                        mPassword.getText().toString(),
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mAddress.getText().toString(),
                        mCityOrVillage.getText().toString(),
                        mPesel.getText().toString(),
                        mEmail.getText().toString()

                );

                mAddEmployeeViewModel.insertEmployee(employee);

            }
        });
    }

}