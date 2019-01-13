package com.edu.pk.student.mydata;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pk.R;

public class EditActivity extends AppCompatActivity {

    private AutoCompleteTextView mAddress;
    private AutoCompleteTextView mCityOrVillage;
    private AutoCompleteTextView mVoivodeship;
    private AutoCompleteTextView mOtherNumber;
    private AutoCompleteTextView mEmail;
    private EditViewModel mEditViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mAddress = (AutoCompleteTextView) findViewById(R.id.address_student_data_edit);
        mCityOrVillage = (AutoCompleteTextView) findViewById(R.id.city_or_village_student_data_edit);
        mVoivodeship = (AutoCompleteTextView) findViewById(R.id.voivodeship_student_data_edit);
        mOtherNumber = (AutoCompleteTextView) findViewById(R.id.other_number_student_data_edit);
        mEmail = (AutoCompleteTextView) findViewById(R.id.email_student_data_edit);
        mEditViewModel = ViewModelProviders.of(this).get(EditViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.edit_data_student, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer otherNumber = null;
                try {
                    otherNumber  = Integer.parseInt(mOtherNumber.getText().toString());
                }catch (Exception e) {
                    e.printStackTrace();
                }

                String address = mAddress.getText().toString();
                String cityOrVillage = mCityOrVillage.getText().toString();
                String voivodeship = mVoivodeship.getText().toString();
                String email = mEmail.getText().toString();

                if(!TextUtils.isEmpty(address)){ mEditViewModel.setAddress(address); }

                if(!TextUtils.isEmpty(cityOrVillage)){ mEditViewModel.setCityOrVillage(cityOrVillage); }

                if(!TextUtils.isEmpty(voivodeship)){ mEditViewModel.setVoivodeship(voivodeship); }

                if(otherNumber != null){ mEditViewModel.setOtherNumber(otherNumber); }

                if(!TextUtils.isEmpty(email)){ mEditViewModel.setEmail(email); }

                mEditViewModel.updateStudentData();

                mAddress.setText("");
                mCityOrVillage.setText("");
                mVoivodeship.setText("");
                mOtherNumber.setText("");
                mEmail.setText("");
                toast.show();
            }
        });

    }

}
