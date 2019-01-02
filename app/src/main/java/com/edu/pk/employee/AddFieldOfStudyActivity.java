package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.FieldOfStudy;

public class AddFieldOfStudyActivity extends BaseActivity {

    private AutoCompleteTextView mFieldOfStudyName;
    private Spinner mDepartments;
    private ArrayAdapter<String> mAdapter;
    private String[] mDepartmentsName = {"WA", "WFMiI", "WIEiK", "WIL", "WIŚ", "WIiTCh", "WM"};
    private AddFieldOfStudyViewModel mAddFieldOfStudyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_field_of_study);

        mFieldOfStudyName = (AutoCompleteTextView) findViewById(R.id.field_of_study_name);
        mDepartments = (Spinner) findViewById(R.id.departments);
        mAddFieldOfStudyViewModel = ViewModelProviders.of(this).get(AddFieldOfStudyViewModel.class);

        mAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, mDepartmentsName);
        mDepartments.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.add_field_of_study_toast, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FieldOfStudy fieldOfStudy;
                fieldOfStudy = new FieldOfStudy(
                        mFieldOfStudyName.getText().toString(),
                        mDepartments.getSelectedItem().toString()
                );
                mAddFieldOfStudyViewModel.insertFieldOfStudy(fieldOfStudy);
                mAddFieldOfStudyViewModel.insertFieldOfStudyCourse(fieldOfStudy);

                mFieldOfStudyName.setText("");
                mDepartments.setAdapter(mAdapter);
                toast.show();
            }
        });
    }
}
