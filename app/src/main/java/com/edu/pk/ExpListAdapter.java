package com.edu.pk;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpListAdapter extends BaseExpandableListAdapter {

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