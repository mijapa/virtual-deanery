package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.edu.pk.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class AddFieldOfStudyActivityTest {

    @Rule
    public ActivityTestRule<AddFieldOfStudyActivity> mActivityTestRule = new ActivityTestRule<>(AddFieldOfStudyActivity.class);

    @Test
    public void testLaunch() {
        AddFieldOfStudyActivity activity = mActivityTestRule.getActivity();

        AddFieldOfStudyViewModel mAddFieldOfStudyViewModel = ViewModelProviders.of(activity).get(AddFieldOfStudyViewModel.class);
        AutoCompleteTextView mFieldOfStudyName = activity.findViewById(R.id.field_of_study_name);
        TextView mDepartmentName = activity.findViewById(R.id.department_name);
        Spinner mDepartments = activity.findViewById(R.id.departments);

        assertThat(mAddFieldOfStudyViewModel, notNullValue());
        assertThat(mFieldOfStudyName, notNullValue());
        assertThat(mDepartmentName, notNullValue());
        assertThat(mDepartments, notNullValue());

    }

}
