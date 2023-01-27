package com.example.new_mobile_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.new_mobile_project.Models.feedback_model;
import com.example.new_mobile_project.R;

import java.util.ArrayList;

public class feedbacklistadapter extends BaseAdapter {
    private Context context;
    private static LayoutInflater inflater = null;
    private ArrayList<feedback_model> feedArrayList;

    public feedbacklistadapter(Context context, ArrayList<feedback_model> feedArrayList) {
        this.context = context;
        this.feedArrayList = feedArrayList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return feedArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        if(row == null) {
            row = inflater.inflate(R.layout.feedbackviewer_row, null);
        }
        TextView feed_txt = (TextView)row.findViewById(R.id.feedtxt);
        TextView feedrate = (TextView)row.findViewById(R.id.feedrate);
        feedback_model feed = new feedback_model();
        feed = feedArrayList.get(position);
        feed_txt.setText(feed.getFeedtxt());
        feedrate.setText("rating: "+feed.getFeedrate() +" Stars");
        return row;
    }
}
