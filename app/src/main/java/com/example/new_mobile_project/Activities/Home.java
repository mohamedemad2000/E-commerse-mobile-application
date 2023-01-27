package com.example.new_mobile_project.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.new_mobile_project.Adapters.SimpleFragmentPagerAdapter;
import com.example.new_mobile_project.R;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(),3));

        TabLayout tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.searchmenu:
                Intent intent = new Intent(Home.this,SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.cartmenu:
                Intent intent2 = new Intent(Home.this,CartActivity.class);
                startActivity(intent2);
                return true;
            case  R.id.logoutmenu:
                sharedPreferences = getSharedPreferences("remember me",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("username",null);
                editor.putString("password",null);
                editor.putBoolean("login",false);
                editor.apply();
                Intent intent3 = new Intent(Home.this,MainActivity.class);
                startActivity(intent3);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}