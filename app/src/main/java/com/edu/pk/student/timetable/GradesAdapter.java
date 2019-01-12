package com.edu.pk.student.timetable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.pk.R;
import com.edu.pk.data.Course;
import com.edu.pk.data.Grade;

import java.util.List;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.GradesViewHolder> {

    private final LayoutInflater mInflater;
    private List<Grade> mGrades; // Cached copy of words
    private List<Course> mCourseList;

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
        Integer courseNo = current.getCourseNo();
        String courseName = "";
        Integer term = 0;
        for (Course x : mCourseList) {
            if (x.getCourseNo().equals(courseNo)) {
                courseName = x.getName();
                term = x.getTerm();
                break;
            }

        }
        holder.gradeItemView.setText("Semestr: " + term + ", Przedmiot: " + courseName + ", Ocena: " + current.getGrade());
    }

    void setGrades(List<Grade> grades) {
        mGrades = grades;
        notifyDataSetChanged();
    }

    public void setCourses(List<Course> courseList) {
        mCourseList = courseList;
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