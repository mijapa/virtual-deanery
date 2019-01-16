package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.AutoCompleteTextView;

import com.edu.pk.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class EditStudentDataActivityTest {

    @Rule
    public ActivityTestRule<EditStudentDataActivity> mActivityTestRule = new ActivityTestRule<>(EditStudentDataActivity.class);

    @Test
    public void testLaunch() {
        EditStudentDataActivity activity = mActivityTestRule.getActivity();

        EditStudentDataViewModel mEditStudentDataViewModel = ViewModelProviders.of(activity).get(EditStudentDataViewModel.class);
        AutoCompleteTextView mNiuStudentEdit = activity.findViewById(R.id.niu_student_edit);
        AutoCompleteTextView mAlbumNumberStudentEdit = activity.findViewById(R.id.album_number_student_edit);
        AutoCompleteTextView mPeselStudentEdit = activity.findViewById(R.id.pesel_student_edit);
        AutoCompleteTextView mFirstNameStudentEdit = activity.findViewById(R.id.first_name_student_edit);
        AutoCompleteTextView mLastNameStudentEdit = activity.findViewById(R.id.last_name_student_edit);
        AutoCompleteTextView mFamilyNameStudentEdit = activity.findViewById(R.id.family_name_student_edit);
        AutoCompleteTextView mSexStudentEdit = activity.findViewById(R.id.sex_student_edit);
        AutoCompleteTextView mAddressStudentEdit = activity.findViewById(R.id.address_student_edit);
        AutoCompleteTextView mCityOrVillageStudentEdit = activity.findViewById(R.id.city_or_village_student_edit);
        AutoCompleteTextView mVoivodeshipStudentEdit = activity.findViewById(R.id.voivodeship_student_edit);
        AutoCompleteTextView mCountryStudentEdit = activity.findViewById(R.id.country_student_edit);
        AutoCompleteTextView mDistanceFromTheCheckInPlaceStudentEdit = activity.findViewById(R.id.distance_from_the_check_in_place_student_edit);
        AutoCompleteTextView mDateOfBirthStudentEdit = activity.findViewById(R.id.date_of_birth_student_edit);
        AutoCompleteTextView mPlaceOfBirthStudentEdit = activity.findViewById(R.id.place_of_birth_student_edit);
        AutoCompleteTextView mFatherNameStudentEdit = activity.findViewById(R.id.father_name_student_edit);
        AutoCompleteTextView mMotherNameStudentEdit = activity.findViewById(R.id.mother_name_student_edit);
        AutoCompleteTextView mMotherFamilyNameStudentEdit = activity.findViewById(R.id.mother_family_name_student_edit);
        AutoCompleteTextView mMaritalStatusStudentEdit = activity.findViewById(R.id.marital_status_student_edit);
        AutoCompleteTextView mForeigerStudentEdit = activity.findViewById(R.id.foreigner_student_edit);
        AutoCompleteTextView mPhoneNumberStudentEdit = activity.findViewById(R.id.phone_number_student_edit);
        AutoCompleteTextView mOtherNumberStudentEdit = activity.findViewById(R.id.other_number_student_edit);
        AutoCompleteTextView mBankAccountStudentEdit = activity.findViewById(R.id.bank_account_student_edit);
        AutoCompleteTextView mEmailStudentEdit = activity.findViewById(R.id.email_student_edit);
        AutoCompleteTextView mDateOfStudyStartStudentEdit = activity.findViewById(R.id.date_of_study_start_student_edit);
        AutoCompleteTextView mTermStudentEdit = activity.findViewById(R.id.term_student_edit);

        assertThat(mEditStudentDataViewModel, notNullValue());
        assertThat(mNiuStudentEdit, notNullValue());
        assertThat(mAlbumNumberStudentEdit, notNullValue());
        assertThat(mPeselStudentEdit, notNullValue());
        assertThat(mFirstNameStudentEdit, notNullValue());
        assertThat(mLastNameStudentEdit, notNullValue());
        assertThat(mFamilyNameStudentEdit, notNullValue());
        assertThat(mSexStudentEdit, notNullValue());
        assertThat(mAddressStudentEdit, notNullValue());
        assertThat(mCityOrVillageStudentEdit, notNullValue());
        assertThat(mVoivodeshipStudentEdit, notNullValue());
        assertThat(mCountryStudentEdit, notNullValue());
        assertThat(mDistanceFromTheCheckInPlaceStudentEdit, notNullValue());
        assertThat(mDateOfBirthStudentEdit, notNullValue());
        assertThat(mPlaceOfBirthStudentEdit, notNullValue());
        assertThat(mFatherNameStudentEdit, notNullValue());
        assertThat(mMotherNameStudentEdit, notNullValue());
        assertThat(mMotherFamilyNameStudentEdit, notNullValue());
        assertThat(mMaritalStatusStudentEdit, notNullValue());
        assertThat(mForeigerStudentEdit, notNullValue());
        assertThat(mPhoneNumberStudentEdit, notNullValue());
        assertThat(mOtherNumberStudentEdit, notNullValue());
        assertThat(mBankAccountStudentEdit, notNullValue());
        assertThat(mEmailStudentEdit, notNullValue());
        assertThat(mDateOfStudyStartStudentEdit, notNullValue());
        assertThat(mTermStudentEdit, notNullValue());

    }

}
