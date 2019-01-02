package com.edu.pk.employee;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.StudentApplication;

import java.util.List;

public class WaitingRoomActivity extends BaseActivity {

    private WaitingRoomViewModel mWaitingRoomViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WaitingRoomAdapter adapter = new WaitingRoomAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                String whichApplication = adapter.getDescription(position);
                if(whichApplication.contains("Wniosek o rezerwację")){
                    Integer applicationNumber = adapter.getApplicationNumber(position);
                    Intent intent = new Intent(getApplicationContext(), AssignADormActivity.class);
                    intent.putExtra("albumNo", Integer.toString(adapter.getAlbumNo(position))); //TODO nie jawne przekazywanie
                    intent.putExtra("applicationNumber", applicationNumber.toString());
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Wniosek");
                    builder.setMessage("Czy chcesz zaakceptować wniosek?");
                    builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mWaitingRoomViewModel.setStatusApplication(adapter.getApplicationNumber(position), "zaakceptowany");
                            adapter.notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mWaitingRoomViewModel.setStatusApplication(adapter.getApplicationNumber(position), "nie zaakceptowany");
                            adapter.notifyDataSetChanged();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        }));

        mWaitingRoomViewModel = ViewModelProviders.of(this).get(WaitingRoomViewModel.class);
        mWaitingRoomViewModel.getStudentApplications().observe(this, new Observer<List<StudentApplication>>() {
            @Override
            public void onChanged(@Nullable final List<StudentApplication> studentApplications) {
                adapter.setStudentApplications(studentApplications);
            }
        });
    }

}
