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

import com.edu.pk.employee.AddStudentViewModel;
import com.edu.pk.employee.EmployeeMenuActivity;
import com.edu.pk.lecturer.LecturerMenuActivity;
import com.edu.pk.student.MenuActivity;

/**
 * A login screen that offers login via niu/password.
 */
public class LoginActivity extends AppCompatActivity {

    private static String currentUser = null;
    private LoginViewModel mLoginViewModel;
    // UI references.
    private static AutoCompleteTextView mNiu;
    private static EditText mPassword;
    private Button mNiuSignInButton;

    AddStudentViewModel mAddStudentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu);
        mNiuSignInButton = (Button) findViewById(R.id.NIU_sign_in_button);
        mPassword = (EditText) findViewById(R.id.password);
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        mAddStudentViewModel = ViewModelProviders.of(this).get(AddStudentViewModel.class);

        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
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
                        /*mNiu.setText("");
                        mPassword.setText("");*/
                    }
                    return true;
                }
                return false;
            }
        });

        mNiuSignInButton.setOnClickListener(new OnClickListener() {
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
                    /*mNiu.setText("");
                    mPassword.setText("");*/
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
        mNiu.setError(null);
        mPassword.setError(null);

        // Store values at the time of the login attempt.
        String NIU = mNiu.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!checkLog()) {
            //mNiu.setError(getString(R.string.error_invalid_one));
            mPassword.setError(getString(R.string.error_invalid_one));
            focusView = mNiu;
            cancel = true;
        }

        // Check for a valid NIU
        if (TextUtils.isEmpty(NIU)) {
            mNiu.setError(getString(R.string.error_field_required));
            mPassword.setError(null);
            focusView = mNiu;
            cancel = true;
        } else if (!isNiuValid(NIU)) {
            //mNiu.setError(getString(R.string.error_invalid_NIU));
            mPassword.setError(getString(R.string.error_invalid_one));
            focusView = mNiu;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            mPassword.setError(getString(R.string.error_field_required));
            mNiu.setError(null);
            focusView = mPassword;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
    }

    private boolean isNiuValid(String niu) {
        try {
            double value = Double.parseDouble(niu);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean checkLog() {
        String password = mPassword.getText().toString();
        Integer niu = Integer.valueOf(mNiu.getText().toString());
        mLoginViewModel.setNiu(niu);
        if (niu < 10 || niu == 123060) {
            currentUser = "s";
        } else if (niu >= 10 && niu < 20) {
            currentUser = "p";
        } else {
            currentUser = "l";
        }
        return mLoginViewModel.checkLoginPassword(niu, password);
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}