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

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class AddLecturerActivityTest {

    @Rule
    public ActivityTestRule<AddLecturerActivity> mActivityTestRule = new ActivityTestRule<>(AddLecturerActivity.class);

    @Test
    public void testLaunch() {
        AddLecturerActivity activity = mActivityTestRule.getActivity();

        AddLecturerViewModel mAddLecturerViewModel = ViewModelProviders.of(activity).get(AddLecturerViewModel.class);
        AutoCompleteTextView mNiuLecturer = activity.findViewById(R.id.niu_lecturer);
        AutoCompleteTextView mPasswordLecturer = activity.findViewById(R.id.password_lecturer);
        AutoCompleteTextView mFirstNameLecturer = activity.findViewById(R.id.first_name_lecturer);
        AutoCompleteTextView mLastNameLecturer = activity.findViewById(R.id.last_name_lecturer);
        AutoCompleteTextView mAddressLecturer = activity.findViewById(R.id.address_lecturer);
        AutoCompleteTextView mPhoneNumberLecturer = activity.findViewById(R.id.phone_number_lecturer);
        TextView mTextInformationAboutCourses = activity.findViewById(R.id.text_information_about_courses);
        AutoCompleteTextView mCourse1 = activity.findViewById(R.id.course1);
        AutoCompleteTextView mCourse2 = activity.findViewById(R.id.course2);
        AutoCompleteTextView mCourse3 = activity.findViewById(R.id.course3);

        assertThat(mAddLecturerViewModel, notNullValue());
        assertThat(mNiuLecturer, notNullValue());
        assertThat(mPasswordLecturer, notNullValue());
        assertThat(mFirstNameLecturer, notNullValue());
        assertThat(mLastNameLecturer, notNullValue());
        assertThat(mAddressLecturer, notNullValue());
        assertThat(mPhoneNumberLecturer, notNullValue());
        assertThat(mTextInformationAboutCourses, notNullValue());
        assertThat(mCourse1, notNullValue());
        assertThat(mCourse2, notNullValue());
        assertThat(mCourse3, notNullValue());

    }

}
