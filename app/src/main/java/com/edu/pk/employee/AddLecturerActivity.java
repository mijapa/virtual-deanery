package com.edu.pk.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Course;
import com.edu.pk.data.Lecturer;
import com.edu.pk.data.LecturerCourse;

public class AddLecturerActivity extends BaseActivity {

    private AutoCompleteTextView mNiu;
    private AutoCompleteTextView mPassword;
    private AutoCompleteTextView mFirstName;
    private AutoCompleteTextView mLastName;
    private AutoCompleteTextView mAddress;
    private AutoCompleteTextView mPhoneNumber;
    private AddLecturerViewModel mAddLecturerViewModel;
    private ArrayAdapter<Course> mAdapter;
    private AutoCompleteTextView mCourse1;
    private AutoCompleteTextView mCourse2;
    private AutoCompleteTextView mCourse3;
    private int position1;
    private int position2;
    private int position3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lecturer);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu_lecturer);
        mPassword = (AutoCompleteTextView) findViewById(R.id.password_lecturer);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.first_name_lecturer);
        mLastName = (AutoCompleteTextView) findViewById(R.id.last_name_lecturer);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address_lecturer);
        mPhoneNumber = (AutoCompleteTextView) findViewById(R.id.phone_number_lecturer);
        mCourse1 = (AutoCompleteTextView) findViewById(R.id.course1);
        mCourse2 = (AutoCompleteTextView) findViewById(R.id.course2);
        mCourse3 = (AutoCompleteTextView) findViewById(R.id.course3);
        mAddLecturerViewModel = ViewModelProviders.of(this).get(AddLecturerViewModel.class);



        mAdapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.item, mAddLecturerViewModel.getCourseList());
        mCourse1.setAdapter(mAdapter);
        mCourse2.setAdapter(mAdapter);
        mCourse3.setAdapter(mAdapter);

        mCourse1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { position1 = position;
            }
        });
        mCourse2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { position2 = position;
            }
        });
        mCourse3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { position3 = position;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.add_lecturer_toast, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course c1 = mAdapter.getItem(position1);
                Course c2 = mAdapter.getItem(position2);
                Course c3 = mAdapter.getItem(position3);
                Lecturer lecturer;
                lecturer = new Lecturer(
                        Integer.parseInt(mNiu.getText().toString()),
                        mPassword.getText().toString(),
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mAddress.getText().toString(),
                        Integer.parseInt(mPhoneNumber.getText().toString())
                );

                mAddLecturerViewModel.insertLecturer(lecturer);
                mAddLecturerViewModel.insertLecturerCourse( new LecturerCourse(1, Integer.parseInt(mNiu.getText().toString())));
                mAddLecturerViewModel.insertLecturerCourse( new LecturerCourse(c1.getCourseNo(), Integer.parseInt(mNiu.getText().toString())));
                mAddLecturerViewModel.insertLecturerCourse( new LecturerCourse(c2.getCourseNo(), Integer.parseInt(mNiu.getText().toString())));
                mAddLecturerViewModel.insertLecturerCourse( new LecturerCourse(c3.getCourseNo(), Integer.parseInt(mNiu.getText().toString())));
                mNiu.setText("");
                mPassword.setText("");
                mFirstName.setText("");
                mLastName.setText("");
                mAddress.setText("");
                mPhoneNumber.setText("");
                mCourse1.setText("");
                mCourse2.setText("");
                mCourse3.setText("");

                toast.show();
            }
        });
    }

}