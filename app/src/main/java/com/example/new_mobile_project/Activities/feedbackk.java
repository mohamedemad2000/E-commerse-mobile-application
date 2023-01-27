package com.example.new_mobile_project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.R;


public class feedbackk extends AppCompatActivity {
    Spinner spin;
    EcommerceDatabase c;
    Button b;
    EditText feeder;
    String[] rating={"one","two","three","four","five"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackk);
        b=findViewById(R.id.button);
        feeder=findViewById(R.id.feedstring);
        c=new EcommerceDatabase(this);
        spin = (Spinner) findViewById(R.id.simpleSpinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,rating);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.addfeed(feeder.getText().toString(),spin.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(),"feedback added successfully",Toast.LENGTH_SHORT).show();
                Intent R=new Intent(feedbackk.this,MainActivity.class);
                startActivity(R);
            }
        });
    }

}