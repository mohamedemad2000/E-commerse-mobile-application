package com.example.new_mobile_project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.R;

public class admin extends AppCompatActivity {
    EditText pro_name;
    EditText pro_desc;
    EditText pro_price;
    EditText pro_quantity;
    EditText pro_category;
    Button add;
    Button show;
    Button fed;
    Button chart;
    Button report;
    EcommerceDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        pro_name=findViewById(R.id.pro_name);
        pro_desc=findViewById(R.id.pro_desc);
        pro_price=findViewById(R.id.pro_price);
        pro_category=findViewById(R.id.pro_cat);
        pro_quantity=findViewById(R.id.pro_quant);
        add=findViewById(R.id.btn_add);
        show=findViewById(R.id.btn_view);
        fed=findViewById(R.id.btn_feedinfo);
        chart=findViewById(R.id.btn_chart);
        report=findViewById(R.id.btn_report);
        database=new EcommerceDatabase(this);

        fed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin.this,feedbackviewer.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.add(pro_name.getText().toString(),pro_desc.getText().toString(),Integer.valueOf(pro_price.getText().toString().trim()),Integer.valueOf(pro_quantity.getText().toString().trim()),Integer.valueOf(pro_category.getText().toString()));
                Toast.makeText(getApplicationContext(),"item added succesfully",Toast.LENGTH_SHORT).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin.this,show.class);
                startActivity(i);
            }
        });
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin.this,ChartActivity.class);
                startActivity(i);
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin.this,AdminReportActivity.class);
                startActivity(i);
            }
        });
    }

}