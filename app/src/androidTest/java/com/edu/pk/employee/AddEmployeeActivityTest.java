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
public class AddEmployeeActivityTest {

    @Rule
    public ActivityTestRule<AddEmployeeActivity> mActivityTestRule = new ActivityTestRule<>(AddEmployeeActivity.class);

    @Test
    public void testLaunch() {
        AddEmployeeActivity activity = mActivityTestRule.getActivity();

        AddEmployeeViewModel mAddEmployeeViewModel = ViewModelProviders.of(activity).get(AddEmployeeViewModel.class);
        AutoCompleteTextView mNiuEmployee = activity.findViewById(R.id.niu_employee);
        AutoCompleteTextView mPasswordChange = activity.findViewById(R.id.password_employee);
        AutoCompleteTextView mFirstNameEmployee = activity.findViewById(R.id.first_name_employee);
        AutoCompleteTextView mLastNameEmployee = activity.findViewById(R.id.last_name_employee);
        AutoCompleteTextView mAddressEmployee = activity.findViewById(R.id.address_employee);
        AutoCompleteTextView mCityOrVillageEmployee = activity.findViewById(R.id.city_or_village_employee);
        AutoCompleteTextView mPeselEmployee = activity.findViewById(R.id.pesel_employee);
        AutoCompleteTextView mEmailEmployee = activity.findViewById(R.id.email_employee);

        assertThat(mAddEmployeeViewModel, notNullValue());
        assertThat(mNiuEmployee, notNullValue());
        assertThat(mPasswordChange, notNullValue());
        assertThat(mFirstNameEmployee, notNullValue());
        assertThat(mLastNameEmployee, notNullValue());
        assertThat(mAddressEmployee, notNullValue());
        assertThat(mCityOrVillageEmployee, notNullValue());
        assertThat(mPeselEmployee, notNullValue());
        assertThat(mEmailEmployee, notNullValue());

    }
}
