package com.edu.pk;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MyDataActivity extends AppCompatActivity {

    private String DEBUG_TAG = "DEBUG_TAG";

    private List<String> mCategoryList;
    private List<Data> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DataList data = new DataList();
        mCategoryList = data.getCategoryList();
        mDataList = data.getDataList();

        expandableLeistView();

    }

    private ArrayMap<Integer, List> splitData(List<String> category, List<Data> data) {

        ArrayMap<Integer, List> mItem = new ArrayMap();

        for (int c = 0; c < category.size(); c++) {
            List<String> array = new ArrayList<>();

            for (int p = 0; p < data.size(); p++) {
                if (data.get(p).getCategory().contains(category.get(c))) {
                    array.add(data.get(p).getName() + ": " + data.get(p).getValue());
                }
            }

            mItem.put(c, array);
        }
        return mItem;
    }


    private void expandableLeistView() {

        ExpandableListView expandableLeistView = findViewById(R.id.expandableListView);
        ArrayMap<Integer, List> mDatas = splitData(mCategoryList, mDataList);
        ExpListAdapter mAdapter = new ExpListAdapter(this);
        mAdapter.setData(mCategoryList, mDatas);
        expandableLeistView.setAdapter(mAdapter);
        expandableLeistView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(DEBUG_TAG, "groupPosition= " + groupPosition + " childPosition= " + childPosition);
                return false;
            }
        });
    }
}

