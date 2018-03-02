package com.sahu97gmail.kedarnath.bioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void men(View view){
        Intent intent=new Intent(this,MenActivity.class);
        Toast.makeText(HomeActivity.this,"Men",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void women(View view){
        Intent intent=new Intent(this,WomenActivity.class);
        Toast.makeText(HomeActivity.this,"Women",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void contact(View view){
        Intent intent=new Intent(this,ContactActivity.class);
        startActivity(intent);
    }
}
