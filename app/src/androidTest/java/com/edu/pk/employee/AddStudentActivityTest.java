package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.edu.pk.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class AddStudentActivityTest {

    @Rule
    public ActivityTestRule<AddStudentActivity> mActivityTestRule = new ActivityTestRule<>(AddStudentActivity.class);

    @Test
    public void testLaunch() {
        AddStudentActivity activity = mActivityTestRule.getActivity();

        AddStudentViewModel mAddStudentViewModel = ViewModelProviders.of(activity).get(AddStudentViewModel.class);
        AutoCompleteTextView mNiuStudent = activity.findViewById(R.id.niu_student);
        AutoCompleteTextView mAlbumNumberStudent = activity.findViewById(R.id.album_number_student);
        AutoCompleteTextView mPasswordStudent = activity.findViewById(R.id.password_student);
        AutoCompleteTextView mPeselStudent = activity.findViewById(R.id.pesel_student);
        AutoCompleteTextView mFirstNameStudent = activity.findViewById(R.id.first_name_student);
        AutoCompleteTextView mLastNameStudent = activity.findViewById(R.id.last_name_student);
        AutoCompleteTextView mFamilyNameStudent = activity.findViewById(R.id.family_name_student);
        AutoCompleteTextView mSexStudent = activity.findViewById(R.id.sex_student);
        AutoCompleteTextView mAddressStudent = activity.findViewById(R.id.address_student);
        AutoCompleteTextView mCityOrVillageStudent = activity.findViewById(R.id.city_or_village_student);
        AutoCompleteTextView mVoivodeshipStudent = activity.findViewById(R.id.voivodeship_student);
        AutoCompleteTextView mCountryStudent = activity.findViewById(R.id.country_student);
        AutoCompleteTextView mDistanceFromTheCheckInPlaceStudent = activity.findViewById(R.id.distance_from_the_check_in_place_student);
        AutoCompleteTextView mDateOfBirthStudent = activity.findViewById(R.id.date_of_birth_student);
        AutoCompleteTextView mPlaceOfBirthStudent = activity.findViewById(R.id.place_of_birth_student);
        AutoCompleteTextView mFatherNameStudent = activity.findViewById(R.id.father_name_student);
        AutoCompleteTextView mMotherNameStudent = activity.findViewById(R.id.mother_name_student);
        AutoCompleteTextView mMotherFamilyNameStudent = activity.findViewById(R.id.mother_family_name_student);
        AutoCompleteTextView mMaritalStatusStudent = activity.findViewById(R.id.marital_status_student);
        AutoCompleteTextView mForeignerStudent = activity.findViewById(R.id.foreigner_student);
        AutoCompleteTextView mPhoneNumberStudent = activity.findViewById(R.id.phone_number_student);
        AutoCompleteTextView mOtherNumberStudent = activity.findViewById(R.id.other_number_student);
        AutoCompleteTextView mBankAccountStudent = activity.findViewById(R.id.bank_account_student);
        AutoCompleteTextView mEmailStudent = activity.findViewById(R.id.email_student);
        AutoCompleteTextView mDateOfStudyStartStudent = activity.findViewById(R.id.date_of_study_start_student);
        AutoCompleteTextView mTermStudent = activity.findViewById(R.id.term_student);
        TextView mInformation = activity.findViewById(R.id.text_information_about_field_of_study);

        assertThat(mAddStudentViewModel, notNullValue());
        assertThat(mNiuStudent, notNullValue());
        assertThat(mAlbumNumberStudent, notNullValue());
        assertThat(mPasswordStudent, notNullValue());
        assertThat(mPeselStudent, notNullValue());
        assertThat(mFirstNameStudent, notNullValue());
        assertThat(mLastNameStudent, notNullValue());
        assertThat(mFamilyNameStudent, notNullValue());
        assertThat(mSexStudent, notNullValue());
        assertThat(mAddressStudent, notNullValue());
        assertThat(mCityOrVillageStudent, notNullValue());
        assertThat(mVoivodeshipStudent, notNullValue());
        assertThat(mCountryStudent, notNullValue());
        assertThat(mDistanceFromTheCheckInPlaceStudent, notNullValue());
        assertThat(mDateOfBirthStudent, notNullValue());
        assertThat(mPlaceOfBirthStudent, notNullValue());
        assertThat(mFatherNameStudent, notNullValue());
        assertThat(mMotherNameStudent, notNullValue());
        assertThat(mMotherFamilyNameStudent, notNullValue());
        assertThat(mMaritalStatusStudent, notNullValue());
        assertThat(mForeignerStudent, notNullValue());
        assertThat(mPhoneNumberStudent, notNullValue());
        assertThat(mOtherNumberStudent, notNullValue());
        assertThat(mBankAccountStudent, notNullValue());
        assertThat(mEmailStudent, notNullValue());
        assertThat(mDateOfStudyStartStudent, notNullValue());
        assertThat(mTermStudent, notNullValue());
        assertThat(mInformation, notNullValue());

    }

}
