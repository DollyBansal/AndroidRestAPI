package com.dolly.restapifetchsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


class RecyclerViewAdapterCustom extends RecyclerView.Adapter<RecyclerViewAdapterCustom.RecyclerViewHolderFeed> {
    private Context context;
    private ArrayList<PoJoDataNext> data;

    public RecyclerViewAdapterCustom(Context context, ArrayList<PoJoDataNext> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerViewHolderFeed onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_feed, parent, false);
        return new RecyclerViewHolderFeed(layoutView);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolderFeed holder, final int position) {
        // set the user fullname in textview
        holder.textview_user_fullname.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class RecyclerViewHolderFeed extends RecyclerView.ViewHolder {
        TextView textview_user_fullname;


        private RecyclerViewHolderFeed(View itemView) {
            super(itemView);
            textview_user_fullname = itemView.findViewById(R.id.textview_user_fullname);
        }
    }
}



