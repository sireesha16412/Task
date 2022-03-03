package com.example.loginformwithedittexts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SharedPrefAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Modelclass> mPrefDataList;

    public SharedPrefAdpter(Context context, List<Modelclass> prefDataList) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mPrefDataList = prefDataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textViewKey.setText(mPrefDataList.get(position).key);
            viewHolder.textViewValue.setText(mPrefDataList.get(position).value);
        }
    }

    @Override
    public int getItemCount() {
            return mPrefDataList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewKey, textViewValue;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewKey = itemView.findViewById(R.id.text_view_key);
            textViewValue =itemView.findViewById(R.id.text_view_value);
        }
    }
}
