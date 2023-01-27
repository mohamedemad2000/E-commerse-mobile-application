package com.example.new_mobile_project.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.R;

public class Recover_password extends AppCompatActivity {

    EditText uname;
    String username;
    TextView pass;
    Button recover;
    EcommerceDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        intialize();
        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoverpassword();
            }
        });
    }

    protected void intialize(){
        uname = findViewById(R.id.mail_recovery_pass);
        pass =findViewById(R.id.pass_recovered);
        recover = (Button)findViewById(R.id.get_pass);
        database = new EcommerceDatabase(this);
    }
    protected void recoverpassword(){
        username = uname.getText().toString();
        String password = database.recoverPassword(username);
        if(password == null)
        {
            Toast.makeText(getApplicationContext(),"Wrong Username " + ("\ud83d\ude15"),Toast.LENGTH_LONG).show();
        }
        else
            pass.setText("Your Password is: "+password +" "+ ("\ud83d\ude07"));

    }
}