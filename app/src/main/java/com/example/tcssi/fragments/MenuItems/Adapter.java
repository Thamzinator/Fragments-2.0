package com.example.tcssi.fragments.MenuItems;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.SingleApplication;
import com.example.tcssi.fragments.item;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    private static final String TAG = "Adapter";

    Context mContext;
    List<item> mData;

    public Adapter(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
        Log.d(TAG, "Adapter: started");
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.card_item, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: initiated");
        holder.background_img.setImageResource(mData.get(position).getBackground());
        holder.tv_title.setText(mData.get(position).getApplicName());
        holder.tv_desc.setText(mData.get(position).getDesc()+" to choose from");
        holder.tv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent = new Intent(mContext, SingleApplication.class);
                mContext.startActivity(postIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView background_img;
        TextView tv_title, tv_desc;
        Button tv_button;



        public myViewHolder(View itemView) {
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            tv_title = itemView.findViewById(R.id.card_title);
            tv_desc = itemView.findViewById(R.id.card_desc);
            tv_button = itemView.findViewById(R.id.rv_button);

        }
    }
}
