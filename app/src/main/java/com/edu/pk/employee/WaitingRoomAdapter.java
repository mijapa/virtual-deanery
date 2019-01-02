package com.edu.pk.employee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
        if(current.getStatus().contains("oczekujący")) {
            holder.studentApplicationItemView.setText(current.getDescription() + "\nNumer albumu: " + current.getStudentAlbumNo() + "\nOdległość od miejsca zamieszkania: " + current.getDistanceFromTheCheck_InPlace());
            holder.studentApplicationItemView.setBackgroundColor(holder.studentApplicationItemView.getResources().getColor(R.color.colorAccent));
            holder.studentApplicationItemView.setTextSize(15);
        }else{
            holder.setVisibility(false);
        }
    }

    void setStudentApplications(List<StudentApplication> studentApplications) {
        mStudentApplications = studentApplications;
        notifyDataSetChanged();
    }

    public int getApplicationNumber(int position){
        StudentApplication current = mStudentApplications.get(position);
        return current.getApplicationNo();
    }

    public int getAlbumNo(int position){
        StudentApplication current = mStudentApplications.get(position);
        return current.getStudentAlbumNo();
    }

    public String getDescription(int position){
        StudentApplication current = mStudentApplications.get(position);
        return current.getDescription();
    }

    @Override
    public int getItemCount() {
        if (mStudentApplications != null)
            return mStudentApplications.size();
        else return 0;
    }

    class WaitingRoomViewHolder extends RecyclerView.ViewHolder {

        private final TextView studentApplicationItemView;

        public void setVisibility(boolean isVisible){
            RecyclerView.LayoutParams param = (RecyclerView.LayoutParams)itemView.getLayoutParams();
            if (isVisible){
                param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                param.width = LinearLayout.LayoutParams.MATCH_PARENT;
                itemView.setVisibility(View.VISIBLE);
            }else{
                itemView.setVisibility(View.GONE);
                param.height = 0;
                param.width = 0;
            }
            itemView.setLayoutParams(param);
        }

        private WaitingRoomViewHolder(View itemView) {
            super(itemView);
            studentApplicationItemView = itemView.findViewById(R.id.textView);
        }
    }
}
