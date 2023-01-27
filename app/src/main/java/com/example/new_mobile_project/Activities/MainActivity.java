package com.example.new_mobile_project.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.R;

public class MainActivity extends AppCompatActivity {

    EditText username,passwprd;
    Button login_btn;
    TextView forget_pass,sign_up;
    boolean login ;

    CheckBox rememberme;
    EcommerceDatabase database;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    SharedPreferences sp;
    SharedPreferences.Editor Ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intialize();
        checkLogin();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerLogin();

            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Sign_Up_activity.class);
                startActivity(i);
            }
        });

        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Recover_password.class);
                startActivity(intent);
            }
        });

    }

    protected void intialize(){
        username = findViewById(R.id.username_login);
        passwprd = findViewById(R.id.password_login);
        login_btn = findViewById(R.id.btn_login);
        forget_pass = findViewById(R.id.forget_password);
        sign_up = findViewById(R.id.go_sign_up_btn);
        rememberme = findViewById(R.id.remember);
        database = new EcommerceDatabase(this);
        sp=getSharedPreferences("Login", MODE_PRIVATE);
        sharedPref = getSharedPreferences("remember me",MODE_PRIVATE);
    }

    protected void CustomerLogin(){
        String Uname = username.getText().toString();
        String Password = passwprd.getText().toString();
        if (Uname.equals("admin") && Password.equals("admin")){
            Intent l=new Intent(MainActivity.this,admin.class);
            startActivity(l);
        }
        else {
            Cursor cursor = database.customerlogin(Uname,Password);
            if (cursor.getCount() <= 0) {
                Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

            } else {
                if(rememberme.isChecked())
                {
                    keeplogin(Uname,Password);
                }
                Toast.makeText(getApplicationContext(), "Successful login", Toast.LENGTH_SHORT).show();
                Ed=sp.edit();
                Ed.putString("Unm",Uname );
                Ed.putString("Psw",Password);
                Ed.commit();
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        }
    }

    protected void keeplogin(String userName, String Upass){
        editor = sharedPref.edit();
        editor.putString("username",userName);
        editor.putString("password",Upass);
        editor.putBoolean("login",true);
        editor.apply();
    }

    protected void checkLogin(){
        login = sharedPref.getBoolean("login",false);
        if(login == true)
        {
            Intent i = new Intent(MainActivity.this,Home.class);
            startActivity(i);
            finish();
        }
    }
}