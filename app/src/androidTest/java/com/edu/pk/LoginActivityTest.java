package com.edu.pk;

import android.arch.lifecycle.ViewModelProviders;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity mLoginActivity = null;

    @Before
    public void setUp() throws Exception {
        mLoginActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        LoginViewModel mLoginViewModel = ViewModelProviders.of(mLoginActivity).get(LoginViewModel.class);
        AutoCompleteTextView mNiu = mLoginActivity.findViewById(R.id.niu);;
        Button mNiuSignInButton = mLoginActivity.findViewById(R.id.NIU_sign_in_button);; ;
        EditText editText = mLoginActivity.findViewById(R.id.password);

        assertNotNull(mLoginViewModel);
        assertNotNull(editText);
        assertNotNull(mNiu);
        assertNotNull(mNiuSignInButton);
    }

    @After
    public void tearDown() throws Exception {
        mLoginActivity = null;
    }
}