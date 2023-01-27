package com.example.new_mobile_project.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.R;

public class edit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final EcommerceDatabase clothes=new EcommerceDatabase(this);
        final EditText name=(EditText) findViewById(R.id.updated_name);
        final EditText desc=(EditText) findViewById(R.id.updated_desc);
        final EditText price=(EditText) findViewById(R.id.updated_price);
        final EditText quantity=(EditText) findViewById(R.id.updated_quant);
        Button update=(Button) findViewById(R.id.btn_update);
        name.setText(getIntent().getExtras().getString("proName"));
        desc.setText(getIntent().getExtras().getString("prodescription"));
        price.setText(getIntent().getExtras().getString("proPrice"));
        quantity.setText(getIntent().getExtras().getString("proQuantity"));
        update.setOnClickListener((v) ->  {
            clothes.update(getIntent().getExtras().getString("proName"),name.getText().toString(),desc.getText().toString(),Integer.valueOf(price.getText().toString().trim()),Integer.valueOf(quantity.getText().toString().trim()));
        });
        Toast.makeText(getApplicationContext(), "Item updated", Toast.LENGTH_SHORT).show();
    }
}
