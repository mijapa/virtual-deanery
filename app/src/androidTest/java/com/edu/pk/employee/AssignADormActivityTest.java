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
public class AssignADormActivityTest {

    @Rule
    public ActivityTestRule<AssignADormActivity> mActivityTestRule = new ActivityTestRule<>(AssignADormActivity.class);

    @Test
    public void testLaunch() {
        AssignADormActivity activity = mActivityTestRule.getActivity();

        AssignADormViewModel mAssignADormViewModel = ViewModelProviders.of(activity).get(AssignADormViewModel.class);
        AutoCompleteTextView mDormName = activity.findViewById(R.id.dorm_name);
        AutoCompleteTextView mRoomName = activity.findViewById(R.id.room_name);

        assertThat(mAssignADormViewModel, notNullValue());
        assertThat(mDormName, notNullValue());
        assertThat(mRoomName, notNullValue());

    }

}
