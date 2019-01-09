package com.edu.pk.student.timetable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.pk.R;
import com.edu.pk.data.Grade;

import java.util.List;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.GradesViewHolder> {

    private final LayoutInflater mInflater;
    private List<Grade> mGrades; // Cached copy of words

    GradesAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public GradesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new GradesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GradesViewHolder holder, int position) {
        Grade current = mGrades.get(position);
        holder.gradeItemView.setText("NIU: " + current.getNiu() + ", CourseNo: " + current.getCourseNo() + ", Grade: " + current.getGrade());
    }

    void setGrades(List<Grade> grades) {
        mGrades = grades;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mGrades has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mGrades != null)
            return mGrades.size();
        else return 0;
    }

    class GradesViewHolder extends RecyclerView.ViewHolder {
        private final TextView gradeItemView;

        private GradesViewHolder(View itemView) {
            super(itemView);
            gradeItemView = itemView.findViewById(R.id.textView);
        }
    }
}