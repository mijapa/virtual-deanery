package com.edu.pk.student.mydata;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

import java.util.ArrayList;
import java.util.List;

public class MyDataActivity extends BaseActivity {

    private String DEBUG_TAG = "DEBUG_TAG";
    private MyDataViewModel mMyDataViewModel;

    private List<String> mCategoryList;
    private List<MyDataViewModel.Data> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMyDataViewModel = ViewModelProviders.of(this).get(MyDataViewModel.class);

        MyDataViewModel.DataList data = mMyDataViewModel.getDataList();
        mCategoryList = data.getCategoryList();
        mDataList = data.getDataList();

        expandableLeistView();

    }

    private ArrayMap<Integer, List> splitData(List<String> category, List<MyDataViewModel.Data> data) {

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

    public void onClick(View view) {
        if(view.getId() == R.id.edit_data) {
            Intent intent = new Intent(this, EditActivity.class);
            startActivity(intent);
        }
    }

    private class ExpListAdapter extends BaseExpandableListAdapter {

        private Context mContext;
        private ArrayList<String> mListCategory;
        private ArrayMap<Integer, List> mListData;

        public ExpListAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this.mListData.get(groupPosition).get(childPosititon);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.my_data_element, null);
            }

            String data = (String) getChild(groupPosition, childPosition);
            TextView listItem = convertView.findViewById(R.id.listItem);
            listItem.setText(data);
            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return this.mListData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this.mListCategory.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this.mListCategory.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.my_data_category
                        , null);
            }

            String category = (String) getGroup(groupPosition);
            TextView listcategory = convertView.findViewById(R.id.listcategory);
            listcategory.setTypeface(null, Typeface.BOLD);
            listcategory.setText(category);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public void setData(List<String> mCategory, ArrayMap<Integer, List> mData) {
            this.mListCategory = (ArrayList<String>) mCategory;
            this.mListData = mData;
        }

    }

}