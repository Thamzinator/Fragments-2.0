package com.example.tcssi.fragments.Main;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tcssi.fragments.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationListAdapter extends ArrayAdapter<Notification> {

    private static final String TAG = "NotificationListAdapter";
    private Context mContext;
    int mResource;

    /**
     * Default constructor for the NotificationListAdapter
     * @param context
     * @param resource
     * @param objects
     */

    public NotificationListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Notification> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the persons info
        String day = getItem(position).getDay();
        String header = getItem(position).getHeader();
        String details = getItem(position).getDetails();

        //Create the notification object with the information
        Notification notification = new Notification(day,header,details);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvDay = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvHeader = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvDetails = (TextView) convertView.findViewById(R.id.textView3);

        tvDay.setText(day);
        tvHeader.setText(header);
        tvDetails.setText(details);

        return convertView;
    }
}
