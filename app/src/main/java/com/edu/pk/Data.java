package com.edu.pk;

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
