package com.edu.pk.student.mydata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.pk.R;
import com.edu.pk.data.Student;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyDataViewHolder> {

    private final LayoutInflater mInflater;
    private List<Student> mStudents; // Cached copy of students

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
        Student current = mStudents.get(position);
        holder.studentItemView.setText(current.getFirstName() + " " + current.getLastName());
    }

    void setWords(List<Student> students) {
        mStudents = students;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mStudents has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mStudents != null)
            return mStudents.size();
        else return 0;
    }

    class MyDataViewHolder extends RecyclerView.ViewHolder {

        private final TextView studentItemView;

        private MyDataViewHolder(View itemView) {
            super(itemView);
            studentItemView = itemView.findViewById(R.id.textView);
        }
    }

}