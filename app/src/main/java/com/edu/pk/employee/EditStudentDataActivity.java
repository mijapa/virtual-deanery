package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

public class EditStudentDataActivity extends BaseActivity {

    private AutoCompleteTextView mNiu;
    private AutoCompleteTextView mAlbumNo;
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
    private AutoCompleteTextView mTerm;
    private EditStudentDataViewModel mEditStudentDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student_data);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu_student_edit);
        mAlbumNo = (AutoCompleteTextView) findViewById(R.id.album_number_student_edit);
        mPesel = (AutoCompleteTextView) findViewById(R.id.pesel_student_edit);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.first_name_student_edit);
        mLastName = (AutoCompleteTextView) findViewById(R.id.last_name_student_edit);
        mFamilyName = (AutoCompleteTextView) findViewById(R.id.family_name_student_edit);
        mSex = (AutoCompleteTextView) findViewById(R.id.sex_student_edit);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address_student_edit);
        mCityOrVillage = (AutoCompleteTextView) findViewById(R.id.city_or_village_student_edit);
        mVoivodeship = (AutoCompleteTextView) findViewById(R.id.voivodeship_student_edit);
        mCountry = (AutoCompleteTextView) findViewById(R.id.country_student_edit);
        mDistanceFromTheCheck_InPlace = (AutoCompleteTextView) findViewById(R.id.distance_from_the_check_in_place_student_edit);
        mDateOfBirth = (AutoCompleteTextView) findViewById(R.id.date_of_birth_student_edit);
        mPlaceOfBirth = (AutoCompleteTextView) findViewById(R.id.place_of_birth_student_edit);
        mFatherName = (AutoCompleteTextView) findViewById(R.id.father_name_student_edit);
        mMotherName = (AutoCompleteTextView) findViewById(R.id.mother_name_student_edit);
        mMotherFamilyName = (AutoCompleteTextView) findViewById(R.id.mother_family_name_student_edit);
        mMaritalStatus = (AutoCompleteTextView) findViewById(R.id.marital_status_student_edit);
        mForeigner = (AutoCompleteTextView) findViewById(R.id.foreigner_student_edit);
        mPhoneNumber = (AutoCompleteTextView) findViewById(R.id.phone_number_student_edit);
        mOtherNumber = (AutoCompleteTextView) findViewById(R.id.other_number_student_edit);
        mBankAccount = (AutoCompleteTextView) findViewById(R.id.bank_account_student_edit);
        mEmail = (AutoCompleteTextView) findViewById(R.id.email_student_edit);
        mDateOfStudyStart = (AutoCompleteTextView) findViewById(R.id.date_of_study_start_student_edit);
        mTerm = (AutoCompleteTextView) findViewById(R.id.term_student_edit);
        mEditStudentDataViewModel = ViewModelProviders.of(this).get(EditStudentDataViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.edit_student_data, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer niu = null; //TODO czy istnieje student o takim niu
                try{
                    niu = Integer.parseInt(mNiu.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer albumNo = null;
                try{
                    albumNo = Integer.parseInt(mAlbumNo.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer sex =  null;
                try{
                    sex = Integer.parseInt(mSex.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer distanceFromTheCheck_InPlace = null;
                try{
                    distanceFromTheCheck_InPlace = Integer.parseInt(mDistanceFromTheCheck_InPlace.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer maritalStatus = null;
                try{
                    maritalStatus  = Integer.parseInt(mMaritalStatus.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer foreigner = null;
                try {
                    foreigner  = Integer.parseInt(mForeigner.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer phoneNumber = null;
                try {
                    phoneNumber  = Integer.parseInt(mPhoneNumber.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer otherNumber = null;
                try {
                    otherNumber  = Integer.parseInt(mOtherNumber.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                Integer term = null;
                try{
                    term  = Integer.parseInt(mTerm.getText().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                String pesel = mPesel.getText().toString();
                String firstName = mFirstName.getText().toString();
                String lastName = mLastName.getText().toString();
                String familyName = mFamilyName.getText().toString();
                String address = mAddress.getText().toString();
                String cityOrVillage = mCityOrVillage.getText().toString();
                String voivodeship = mVoivodeship.getText().toString();
                String country = mCountry.getText().toString();
                String dateOfBirth = mDateOfBirth.getText().toString();
                String placeOfBirth = mPlaceOfBirth.getText().toString();
                String fatherName = mFatherName.getText().toString();
                String motherName = mMotherName.getText().toString();
                String motherFamilyName = mMotherFamilyName.getText().toString();
                String bankAccount = mBankAccount.getText().toString();
                String email = mEmail.getText().toString();
                String dateOfStudyStart = mDateOfStudyStart.getText().toString();

                if(albumNo != null){ mEditStudentDataViewModel.setAlbumNo(niu, albumNo); }

                if(!TextUtils.isEmpty(pesel)){ mEditStudentDataViewModel.setPesel(niu, pesel); }

                if(!TextUtils.isEmpty(firstName)){ mEditStudentDataViewModel.setFirstName(niu, firstName); }

                if(!TextUtils.isEmpty(lastName)){ mEditStudentDataViewModel.setLastName(niu, lastName); }

                if(!TextUtils.isEmpty(familyName)){ mEditStudentDataViewModel.setFamilyName(niu, familyName); }

                if(sex != null){ mEditStudentDataViewModel.setSex(niu, sex); }

                if(!TextUtils.isEmpty(address)){ mEditStudentDataViewModel.setAddress(niu, address); }

                if(!TextUtils.isEmpty(cityOrVillage)){ mEditStudentDataViewModel.setCityOrVillage(niu, cityOrVillage); }

                if(!TextUtils.isEmpty(voivodeship)){ mEditStudentDataViewModel.setVoivodeship(niu, voivodeship); }

                if(!TextUtils.isEmpty(country)){ mEditStudentDataViewModel.setCountry(niu, country); }

                if(distanceFromTheCheck_InPlace != null){ mEditStudentDataViewModel.setDistanceFromTheCheck_InPlace(niu, distanceFromTheCheck_InPlace); }

                if(!TextUtils.isEmpty(dateOfBirth)){ mEditStudentDataViewModel.setDateOfBirth(niu, dateOfBirth); }

                if(!TextUtils.isEmpty(placeOfBirth)){ mEditStudentDataViewModel.setPlaceOfBirth(niu, placeOfBirth); }

                if(!TextUtils.isEmpty(fatherName)){ mEditStudentDataViewModel.setFatherName(niu, fatherName); }

                if(!TextUtils.isEmpty(motherName)){ mEditStudentDataViewModel.setMotherName(niu, motherName); }

                if(!TextUtils.isEmpty(motherFamilyName)){ mEditStudentDataViewModel.setMotherFamilyName(niu, motherFamilyName); }

                if(maritalStatus != null){ mEditStudentDataViewModel.setMaritalStatus(niu, maritalStatus); }

                if(foreigner != null){ mEditStudentDataViewModel.setForeigner(niu, foreigner); }

                if(phoneNumber != null){ mEditStudentDataViewModel.setPhoneNumber(niu, phoneNumber); }

                if(otherNumber != null){ mEditStudentDataViewModel.setOtherNumber(niu, otherNumber); }

                if(!TextUtils.isEmpty(bankAccount)){ mEditStudentDataViewModel.setBankAccount(niu, bankAccount); }

                if(!TextUtils.isEmpty(email)){ mEditStudentDataViewModel.setEmail(niu, email); }

                if(!TextUtils.isEmpty(dateOfStudyStart)){ mEditStudentDataViewModel.setDateOfStudyStart(niu, dateOfStudyStart); }

                if(term != null){ mEditStudentDataViewModel.setTerm(niu, term); }

                mNiu.setText("");
                mAlbumNo.setText("");
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
                mTerm.setText("");
                toast.show();

            }
        });
    }

}
