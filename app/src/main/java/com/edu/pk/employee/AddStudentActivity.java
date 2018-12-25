package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Student;

public class AddStudentActivity extends BaseActivity {

    private AutoCompleteTextView mNiu;
    private AutoCompleteTextView mAlbumNo;
    private AutoCompleteTextView mPassword;
    private AutoCompleteTextView mPesel;
    private AutoCompleteTextView mFirstName;
    private AutoCompleteTextView mLastName;
    private AutoCompleteTextView mFamilyName;
    private AutoCompleteTextView mSex;
    private AutoCompleteTextView mAddress;
    private AutoCompleteTextView mCityOrVillage;
    private AutoCompleteTextView mVoivodeship;
    private AutoCompleteTextView mCountry;
    private AutoCompleteTextView mDistanceFromTheCheck_InPlace;
    private AutoCompleteTextView mDateOfBirth;
    private AutoCompleteTextView mPlaceOfBirth;
    private AutoCompleteTextView mFatherName;
    private AutoCompleteTextView mMotherName;
    private AutoCompleteTextView mMotherFamilyName;
    private AutoCompleteTextView mMaritalStatus;
    private AutoCompleteTextView mForeigner;
    private AutoCompleteTextView mPhoneNumber;
    private AutoCompleteTextView mOtherNumber;
    private AutoCompleteTextView mBankAccount;
    private AutoCompleteTextView mEmail;
    private AutoCompleteTextView mDateOfStudyStart;
    private AddStudentViewModel mAddStudentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu_student);
        mAlbumNo = (AutoCompleteTextView) findViewById(R.id.album_number_student);
        mPassword = (AutoCompleteTextView) findViewById(R.id.password_student);
        mPesel = (AutoCompleteTextView) findViewById(R.id.pesel_student);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.first_name_student);
        mLastName = (AutoCompleteTextView) findViewById(R.id.last_name_student);
        mFamilyName = (AutoCompleteTextView) findViewById(R.id.family_name_student);
        mSex = (AutoCompleteTextView) findViewById(R.id.sex_student);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address_student);
        mCityOrVillage = (AutoCompleteTextView) findViewById(R.id.city_or_village_student);
        mVoivodeship = (AutoCompleteTextView) findViewById(R.id.voivodeship_student);
        mCountry = (AutoCompleteTextView) findViewById(R.id.country_student);
        mDistanceFromTheCheck_InPlace = (AutoCompleteTextView) findViewById(R.id.distance_from_the_check_in_place_student);
        mDateOfBirth = (AutoCompleteTextView) findViewById(R.id.date_of_birth_student);
        mPlaceOfBirth = (AutoCompleteTextView) findViewById(R.id.place_of_birth_student);
        mFatherName = (AutoCompleteTextView) findViewById(R.id.father_name_student);
        mMotherName = (AutoCompleteTextView) findViewById(R.id.mother_name_student);
        mMotherFamilyName = (AutoCompleteTextView) findViewById(R.id.mother_family_name_student);
        mMaritalStatus = (AutoCompleteTextView) findViewById(R.id.marital_status_student);
        mForeigner = (AutoCompleteTextView) findViewById(R.id.foreigner_student);
        mPhoneNumber = (AutoCompleteTextView) findViewById(R.id.phone_number_student);
        mOtherNumber = (AutoCompleteTextView) findViewById(R.id.other_number_student);
        mBankAccount = (AutoCompleteTextView) findViewById(R.id.bank_account_student);
        mEmail = (AutoCompleteTextView) findViewById(R.id.email_student);
        mDateOfStudyStart = (AutoCompleteTextView) findViewById(R.id.date_of_study_start_student);

        mAddStudentViewModel = ViewModelProviders.of(this).get(AddStudentViewModel.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.add_student_toast, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student;
                student = new Student(
                        Integer.parseInt(mNiu.getText().toString()),
                        Integer.parseInt(mAlbumNo.getText().toString()),
                        mPassword.getText().toString(),
                        mPesel.getText().toString(),
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mFamilyName.getText().toString(),
                        Integer.parseInt(mSex.getText().toString()),
                        mAddress.getText().toString(),
                        mCityOrVillage.getText().toString(),
                        mVoivodeship.getText().toString(),
                        mCountry.getText().toString(),
                        Integer.parseInt(mDistanceFromTheCheck_InPlace.getText().toString()),
                        mDateOfBirth.getText().toString(),
                        mPlaceOfBirth.getText().toString(),
                        mFatherName.getText().toString(),
                        mMotherName.getText().toString(),
                        mMotherFamilyName.getText().toString(),
                        Integer.parseInt(mMaritalStatus.getText().toString()),
                        Integer.parseInt(mForeigner.getText().toString()),
                        Integer.parseInt(mPhoneNumber.getText().toString()),
                        Integer.parseInt(mOtherNumber.getText().toString()),
                        mBankAccount.getText().toString(),
                        mEmail.getText().toString(),
                        mDateOfStudyStart.getText().toString()

                );

                mAddStudentViewModel.insertStudent(student);
                mNiu.setText("");
                mAlbumNo.setText("");
                mPassword.setText("");
                mPesel.setText("");
                mFirstName.setText("");
                mLastName.setText("");
                mFamilyName.setText("");
                mSex.setText("");
                mAddress.setText("");
                mCityOrVillage.setText("");
                mVoivodeship.setText("");
                mCountry.setText("");
                mDistanceFromTheCheck_InPlace.setText("");
                mDateOfBirth.setText("");
                mPlaceOfBirth.setText("");
                mFatherName.setText("");
                mMotherName.setText("");
                mMotherFamilyName.setText("");
                mMaritalStatus.setText("");
                mForeigner.setText("");
                mPhoneNumber.setText("");
                mOtherNumber.setText("");
                mBankAccount.setText("");
                mEmail.setText("");
                mDateOfStudyStart.setText("");
                toast.show();
            }
        });
    }
}
