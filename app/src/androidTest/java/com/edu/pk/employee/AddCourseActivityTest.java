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
public class AddCourseActivityTest {

    @Rule
    public ActivityTestRule<AddCourseActivity> mActivityTestRule = new ActivityTestRule<>(AddCourseActivity.class);

    @Test
    public void testLaunch() {
        AddCourseActivity activity = mActivityTestRule.getActivity();

        AddCourseViewModel mAddCourseViewModel = ViewModelProviders.of(activity).get(AddCourseViewModel.class);
        AutoCompleteTextView mCourseNo = activity.findViewById(R.id.course_no);
        AutoCompleteTextView mCourseName = activity.findViewById(R.id.course_name);
        AutoCompleteTextView mCourseEcts = activity.findViewById(R.id.course_ects);
        AutoCompleteTextView mCourseTerm = activity.findViewById(R.id.course_term);
        AutoCompleteTextView mCourseDepartment = activity.findViewById(R.id.course_department);
        AutoCompleteTextView mCourseFieldOfStudy = activity.findViewById(R.id.course_field_of_study);
        AutoCompleteTextView mHourAmount = activity.findViewById(R.id.course_hour_amount);

        assertThat(mAddCourseViewModel, notNullValue());
        assertThat(mCourseNo, notNullValue());
        assertThat(mCourseName, notNullValue());
        assertThat(mCourseEcts, notNullValue());
        assertThat(mCourseTerm, notNullValue());
        assertThat(mCourseDepartment, notNullValue());
        assertThat(mCourseFieldOfStudy, notNullValue());
        assertThat(mHourAmount, notNullValue());
    }

}
