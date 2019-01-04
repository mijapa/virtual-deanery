package com.edu.pk.student.mydata;

import android.content.Context;
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

public class DataList {

    private List<Data> mDataList = new ArrayList<Data>() {
        {
            add(new Data("Dane podstawowe", "Nazwisko, Imię", "Kowalski, Jan"));
            add(new Data("Dane podstawowe", "Nazwisko rodowe", ""));
            add(new Data("Dane podstawowe", "płeć", "Mężczyzna"));

            add(new Data("Dane dodatkowe", "Data rozpoczęcia studiów", "04-08-2018"));
            add(new Data("Dane dodatkowe", "Kraj pochodzenia", "Polska"));
            add(new Data("Dane dodatkowe", "Obcokrajowiec", "nie"));

            add(new Data("Dane teleadresowe", "Telefon", "+48500500500"));
            add(new Data("Dane teleadresowe", "e-mail", "jak@kowalski.pl"));

            add(new Data("Informacje o toku studiów", "Zgoda na elektroniczne udostępnianie dokumentów", " Wyrażono zgodę na udostępnianie dokumentów drogą elektroniczn"));
            add(new Data("Informacje o toku studiów", "Rok/semestr (w roku akad.)", "1 / 2 (2018/2019)"));
            add(new Data("Informacje o toku studiów", "Semestr", "Zimowy"));
            add(new Data("Informacje o toku studiów", "Forma studiów", "Stacjonarne"));

            add(new Data("Ukończona szkoła średnia", "Rodzaj matury", "(nowa matura poziom r)"));
            add(new Data("Ukończona szkoła średnia", "Wystawiający", "Okręgowa Komisja Egzaminacyjna w Krakowie"));

            add(new Data("Ukończona szkoła wyższa", "Nazwa uczelni", ""));

            add(new Data("Dane wojskowe", "Kategoria", ""));

            add(new Data("Badania lekarskie", "Badania lekarskie", "nie"));
            add(new Data("Badania lekarskie", "Ważne do", ""));

        }
    };

    private List<String> mCategoryList = new ArrayList<String>() {
        {
            add("Dane podstawowe");
            add("Dane dodatkowe");
            add("Dane teleadresowe");
            add("Informacje o toku studiów");
            add("Ukończona szkoła średnia");
            add("Ukończona szkoła wyższa");
            add("Dane wojskowe");
            add("Badania lekarskie");
        }
    };

    public List<Data> getDataList() {
        return mDataList;
    }

    public List<String> getCategoryList() {
        return mCategoryList;
    }

}

public class Data {

    private String mCategory;
    private String mName;
    private String mValue;

    public Data(String category, String name, String value) {
        mCategory = category;
        mName = name;
        mValue = value;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getName() {
        return mName;
    }

    public String getValue() {
        return mValue;
    }
}