package com.example.new_mobile_project.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.new_mobile_project.Models.ReportModel;
import com.example.new_mobile_project.R;

import java.util.List;

public class CustomReportItems extends BaseAdapter {
    Context context;
    List<ReportModel> reports;
    LayoutInflater inflater;

    public CustomReportItems(Context context, List<ReportModel> reports){
        this.context=context;
        this.reports=reports;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return reports.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.report_item,null);

        TextView reportUserName =view.findViewById(R.id.report_user_name);
        TextView reportOrderTotalPrice=view.findViewById(R.id.report_order_totalprice);
        TextView reportFeedback=view.findViewById(R.id.report_feedback);
        TextView reportDate=view.findViewById(R.id.report_date);

        reportUserName.setText("order id : "+reports.get(i).getOrderid());
        reportOrderTotalPrice.setText("Customer id: "+ reports.get(i).getCustomerid());
        reportFeedback.setText("Total price: " +reports.get(i).getPrice());
        reportDate.setText("Date: "+reports.get(i).getDate());


        return view;
    }


}
