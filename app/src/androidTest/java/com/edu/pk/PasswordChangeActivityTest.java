package com.edu.pk;

import android.arch.lifecycle.ViewModelProviders;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class PasswordChangeActivityTest {

    @Rule
    public ActivityTestRule<PasswordChangeActivity> mActivityTestRule = new ActivityTestRule<>(PasswordChangeActivity.class);

    @Test
    public void testLaunch() {
        PasswordChangeActivity activity = mActivityTestRule.getActivity();

        PasswordChangeViewModel mPasswordChangeViewModel = ViewModelProviders.of(activity).get(PasswordChangeViewModel.class);
        TextView mCurrentPassword = activity.findViewById(R.id.current_password);
        TextView mNewPassword = activity.findViewById(R.id.new_password);
        TextView mRepeatPassword = activity.findViewById(R.id.repeat_password);
        Button mChange = activity.findViewById(R.id.Change);

        assertThat(mPasswordChangeViewModel, notNullValue());
        assertThat(mCurrentPassword, notNullValue());
        assertThat(mNewPassword, notNullValue());
        assertThat(mRepeatPassword, notNullValue());
        assertThat(mChange, notNullValue());

    }

}
