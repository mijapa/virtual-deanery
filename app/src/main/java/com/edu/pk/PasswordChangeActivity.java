package com.edu.pk;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import com.edu.pk.employee.EmployeeMenuActivity;
import com.edu.pk.lecturer.LecturerMenuActivity;
import com.edu.pk.student.MenuActivity;

public class PasswordChangeActivity extends BaseActivity {

    private TextView mCurrentPassword;
    private TextView mNewPassword;
    private TextView mRepeatPassword;
    private Button mChange;
    private PasswordChangeViewModel mPasswordChangeViewModel;

    private String mNiu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        mNiu = getIntent().getStringExtra("niu");
        mCurrentPassword = (TextView) findViewById(R.id.current_password);
        mNewPassword = (TextView) findViewById(R.id.new_password);
        mRepeatPassword = (TextView) findViewById(R.id.repeat_password);
        mChange = (Button) findViewById(R.id.Change);

        mPasswordChangeViewModel = ViewModelProviders.of(this).get(PasswordChangeViewModel.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mRepeatPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_GO) {
                    if(checkCurrentPassword()) {
                        if(isTheSame()) {
                            mPasswordChangeViewModel.changePassword(mNiu, mNewPassword.getText().toString());
                            return true;
                        }
                    }
                }
                return false;
            }
        });

        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCurrentPassword()) {
                    if(isTheSame()) {
                        mPasswordChangeViewModel.changePassword(mNiu, mNewPassword.getText().toString());
                    }
                }
            }
        });
    }

    public boolean checkCurrentPassword(){
        mCurrentPassword.setError(null);
        mRepeatPassword.setError(null);

        boolean cancel = false;
        View focusView = null;

        if(!mPasswordChangeViewModel.checkCurrentPassword(mNiu, mCurrentPassword.getText().toString())){
            mCurrentPassword.setError(getString(R.string.error_current_password));
            focusView = mCurrentPassword;
            cancel = true;
        }

        if (cancel) {
            mCurrentPassword.setText("");
            mNewPassword.setText("");
            mRepeatPassword.setText("");
            focusView.requestFocus();
            return false;
        }
        return true;
    }

    public boolean isTheSame(){
        mCurrentPassword.setError(null);
        mRepeatPassword.setError(null);

        boolean cancel = false;
        View focusView = null;

        if(!mNewPassword.getText().toString().equals(mRepeatPassword.getText().toString())){
            mRepeatPassword.setError(getString(R.string.error_is_not_the_same));
            focusView = mRepeatPassword;
            cancel = true;
        }

        if (cancel) {
            mNewPassword.setText("");
            mRepeatPassword.setText("");
            focusView.requestFocus();
            return false;
        }
        return true;

    }

    public void onBackPressed(){
        finish();
    }

    public Intent getSupportParentActivityIntent(){
        return getParentActivityIntentImplement();
    }

    public Intent getParentActivityIntent(){
        return getParentActivityIntentImplement();
    }

    private Intent getParentActivityIntentImplement() {
        Intent intent = null;

        Bundle extras = getIntent().getExtras();
        String goToIntent = extras.getString("goto");

        if(goToIntent.equals("MenuActivity")){
            intent = new Intent(this, MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }else if(goToIntent.equals("EmployeeMenuActivity")){
            intent = new Intent(this, EmployeeMenuActivity.class);
        }else{
            intent = new Intent(this, LecturerMenuActivity.class);
        }
        return intent;
    }
}
