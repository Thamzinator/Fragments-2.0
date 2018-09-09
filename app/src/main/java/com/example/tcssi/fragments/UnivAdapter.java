package com.example.tcssi.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class UnivAdapter extends RecyclerView.Adapter<UnivAdapter.ViewHolder>{

    private List<ListItem> listItems;
    private Context context;

    public UnivAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.univ_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());

        holder.mCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Clicked on: "+ position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewHead;
        public TextView textViewDesc;

        CardView mCardLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.univ_name);
            mCardLayout = itemView.findViewById(R.id.univ_parent_layout);
            textViewDesc = itemView.findViewById(R.id.univ_location);
        }
    }
}
