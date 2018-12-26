package com.edu.pk.employee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.pk.R;
import com.edu.pk.data.StudentApplication;

import java.util.List;

public class WaitingRoomAdapter extends RecyclerView.Adapter<WaitingRoomAdapter.WaitingRoomViewHolder> {

    private final LayoutInflater mInflater;
    private List<StudentApplication> mStudentApplications;

    WaitingRoomAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WaitingRoomAdapter.WaitingRoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WaitingRoomAdapter.WaitingRoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final WaitingRoomAdapter.WaitingRoomViewHolder holder,final int position) {
        StudentApplication current = mStudentApplications.get(position);
        holder.studentApplicationItemView.setText(current.getDescription() + "\nNumer albumu: " + current.getStudentAlbumNo() + "\nOdległość od miejsca zamieszkania: " + current.getDistanceFromTheCheck_InPlace() + "\nStatus: " + current.getStatus());
        holder.studentApplicationItemView.setBackgroundColor(holder.studentApplicationItemView.getResources().getColor(R.color.colorAccent));
        holder.studentApplicationItemView.setTextSize(15);
    }

    void setWords(List<StudentApplication> studentApplications) {
        mStudentApplications = studentApplications;
        notifyDataSetChanged();
    }

    public int getApplicationNumber(int position){
        StudentApplication current = mStudentApplications.get(position);
        return current.getAppliactionNo();
    }

    @Override
    public int getItemCount() {
        if (mStudentApplications != null)
            return mStudentApplications.size();
        else return 0;
    }

    class WaitingRoomViewHolder extends RecyclerView.ViewHolder {
        private final TextView studentApplicationItemView;

        private WaitingRoomViewHolder(View itemView) {
            super(itemView);
            studentApplicationItemView = itemView.findViewById(R.id.textView);
        }
    }
}
