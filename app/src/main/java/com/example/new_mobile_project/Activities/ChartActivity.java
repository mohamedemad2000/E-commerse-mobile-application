package com.example.new_mobile_project.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;


import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.Models.ProductsSellingCount;
import com.example.new_mobile_project.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    BarChart barChart;
    PieChart pieChart;
    EcommerceDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


        barChart = findViewById(R.id.barchart);
        pieChart =findViewById(R.id.piechart);

        database = new EcommerceDatabase(getApplicationContext());

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        List<ProductsSellingCount> products=database.getAllProductsSoldCount();

        System.out.println(products.size());

        for(int i=1;i<products.size();i++){
            float value = (float) i*10;
            BarEntry barEntry = new BarEntry(i,products.get(i).getCount());
            PieEntry pieEntry = new PieEntry(i,products.get(i).getProductName());

            barEntries.add(barEntry);
            pieEntries.add(pieEntry);

        }

        BarDataSet barDataSet = new BarDataSet(barEntries,"Products");

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(5000);

        barChart.getDescription().setText("Products Chart");

        barChart.getDescription().setTextColor(Color.BLUE);

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"Products");

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(new PieData(pieDataSet));

        pieChart.animateXY(5000,5000);

        pieChart.getDescription().setEnabled(false);

    }
}