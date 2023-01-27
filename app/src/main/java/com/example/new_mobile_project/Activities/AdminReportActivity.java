package com.example.new_mobile_project.Activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.Models.ReportModel;
import com.example.new_mobile_project.R;

import java.util.ArrayList;
import java.util.List;

public class AdminReportActivity extends AppCompatActivity {
    List<ReportModel> reports;
    EcommerceDatabase database;
    ListView reportListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_report);
        database = new EcommerceDatabase(getApplicationContext());
        reports= new ArrayList<ReportModel>();
        reportListView = (ListView) findViewById(R.id.report_listview);
        System.out.println(database.getNumOfOrders());
        reports=database.getAllReports();
        CustomReportItems customReportItemsAdapter = new CustomReportItems(getApplicationContext(),reports);
        reportListView.setAdapter(customReportItemsAdapter);
    }

}