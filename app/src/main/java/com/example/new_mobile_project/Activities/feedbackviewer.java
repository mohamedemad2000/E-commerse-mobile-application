package com.example.new_mobile_project.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.new_mobile_project.Adapters.feedbacklistadapter;
import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.Models.feedback_model;
import com.example.new_mobile_project.R;

import java.util.ArrayList;

public class feedbackviewer extends AppCompatActivity {

    EcommerceDatabase clothes;
    ArrayList<feedback_model> arrayList;
    feedbacklistadapter adapter;
    GridView viewer;
    ImageView b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackviewer);
        viewer = (GridView) findViewById(R.id.gridforfeed);
        b2 = findViewById(R.id.backbtnmain);
        clothes= new EcommerceDatabase(this);

        arrayList = new ArrayList<feedback_model>();
        arrayList = clothes.showmyfeeds();

        adapter = new feedbacklistadapter(feedbackviewer.this, arrayList);
        viewer.setAdapter(adapter);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedbackviewer.super.onBackPressed();
            }
        });
    }
}