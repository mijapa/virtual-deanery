package com.edu.pk;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.pk.employee.EmployeeMenuActivity;
import com.edu.pk.lecturer.LecturerMenuActivity;
import com.edu.pk.student.MenuActivity;

/**
 * A login screen that offers login via NIU/password.
 */
public class LoginActivity extends AppCompatActivity {
    private static String currentUser = null;
    private LoginViewModel mLoginViewModel;
    private String DEBUG_TAG = "DEBUG_TAG";
    // UI references.
    private AutoCompleteTextView mNIUView;
    private EditText mPasswordView;
    private Button mNIUSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        mNIUView = (AutoCompleteTextView) findViewById(R.id.NIU);
        mNIUSignInButton = (Button) findViewById(R.id.NIU_sign_in_button);
        mPasswordView = (EditText) findViewById(R.id.password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_GO) {
                    attemptLogin();
                    if (checkLog()) {
                        if (currentUser.equals("s")) {
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(intent);
                        }
                        if (currentUser.equals("l")) {
                            Intent intent = new Intent(LoginActivity.this, LecturerMenuActivity.class);
                            startActivity(intent);
                        }
                        if (currentUser.equals("p")) {
                            Intent intent = new Intent(LoginActivity.this, EmployeeMenuActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        mNIUView.setText("");
                        mPasswordView.setText("");
                    }
                    return true;
                }
                return false;
            }
        });

        mNIUSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
                if (checkLog()) {
                    if (currentUser.equals("s")) {
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                    if (currentUser.equals("l")) {
                        Intent intent = new Intent(LoginActivity.this, LecturerMenuActivity.class);
                        startActivity(intent);
                    }
                    if (currentUser.equals("p")) {
                        Intent intent = new Intent(LoginActivity.this, EmployeeMenuActivity.class);
                        startActivity(intent);
                    }
                } else {
                    mNIUView.setText("");
                    mPasswordView.setText("");
                }
            }
        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid NIU, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mNIUView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String NIU = mNIUView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!checkLog()) {
            //mNIUView.setError(getString(R.string.error_invalid_one));
            mPasswordView.setError(getString(R.string.error_invalid_one));
            focusView = mNIUView;
            cancel = true;
        }

        // Check for a valid NIU
        if (TextUtils.isEmpty(NIU)) {
            mNIUView.setError(getString(R.string.error_field_required));
            mPasswordView.setError(null);
            focusView = mNIUView;
            cancel = true;
        } else if (!isNIUValid(NIU)) {
            //mNIUView.setError(getString(R.string.error_invalid_NIU));
            mPasswordView.setError(getString(R.string.error_invalid_one));
            focusView = mNIUView;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            mNIUView.setError(null);
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
    }

    private boolean isNIUValid(String NIU) {
        try {
            double d = Double.parseDouble(NIU);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean checkLog() {
        String email = mNIUView.getText().toString();
        String password = mPasswordView.getText().toString();
        Integer NIU = Integer.valueOf(email);
        //TODO: different email-NIU transformation needed;
        mLoginViewModel.setNIU(NIU);
        if (NIU >= 10) {
            currentUser = "p";
        } else {
            currentUser = "s";
        }
        return mLoginViewModel.checkLoginPassword(email, password);
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

