package com.example.mp_api;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClubList_RecycleView_Adapter extends RecyclerView.Adapter<ClubList_RecycleView_Adapter.ViewHolder> {
    Activity context;
    ArrayList<DataModel> data;

    public ClubList_RecycleView_Adapter(Activity context, ArrayList<DataModel> data) {
        this.context=context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem = layoutInflater.inflate(R.layout.activity_clublist_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataModel current = data.get(position);
        holder.txtName.setText(current.getName());
        holder.txtAddress.setText(current.getAddress());
        holder.txtType.setText(current.getType());
        holder.txtfee.setText(current.getFee());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress, txtType, txtfee;
        public ViewHolder(View listItem) {
            super(listItem);
            txtName = listItem.findViewById(R.id.tvClubName);
            txtAddress = listItem.findViewById(R.id.tvClubAddress);
            txtfee = listItem.findViewById(R.id.tvClubFees);
            txtType = listItem.findViewById(R.id.tvClubType);

        }
    }
}
