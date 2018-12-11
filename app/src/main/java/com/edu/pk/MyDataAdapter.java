package com.edu.pk;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyDataViewHolder> {

    private final LayoutInflater mInflater;
    private List<Student> mWords; // Cached copy of words

    MyDataAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyDataViewHolder holder, int position) {
        Student current = mWords.get(position);
        holder.wordItemView.setText(current.getFirstName() + " " + current.getLastName());
    }

    void setWords(List<Student> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    class MyDataViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private MyDataViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}