package com.example.new_mobile_project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.R;

import java.util.ArrayList;

public class show extends AppCompatActivity {
    ListView productlists;
    EcommerceDatabase clothes;
    ArrayAdapter<String> productadapter;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menushowmovies,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showproducts);
        productlists=findViewById(R.id.pro_list);
        clothes=new EcommerceDatabase(this);
        ArrayList<String> list=clothes.showmyproducts();
        productadapter=new ArrayAdapter<>(this,R.layout.list_row,list);
        productlists.setAdapter(productadapter);
        registerForContextMenu(productlists);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        String selected=((TextView)info.targetView).getText().toString();
        int id=item.getItemId();
        if(id==R.id.Delete){
            productadapter.remove(selected);
            clothes.delete(selected);
            return true;
        }
        if(id==R.id.edit){
            Intent i=new Intent(show.this,edit.class);
            i.putExtra("proName",selected);
            i.putExtra("prodescription",clothes.getdesc(selected));
            i.putExtra("proPrice",clothes.getprice(selected));
            i.putExtra("proQuantity",clothes.getquantity(selected));
            startActivity(i);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onRestart() {
        productadapter.clear();
        clothes=new EcommerceDatabase(this);
        ArrayList<String> list=clothes.showmyproducts();
        productadapter=new ArrayAdapter<>(this,R.layout.list_row,list);
        productlists.setAdapter(productadapter);
        registerForContextMenu(productlists);
        super.onRestart();
    }
}
