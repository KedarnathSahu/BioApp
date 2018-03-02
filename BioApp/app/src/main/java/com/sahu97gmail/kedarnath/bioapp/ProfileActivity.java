package com.sahu97gmail.kedarnath.bioapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    HomeActivity ha=new HomeActivity();
    ImageView iv;
    TextView tv3;//nm
    TextView tv5;//dob
    TextView tv7;//country
    TextView tv9;//prof
    public Button glry_btn;
    Bundle myBndl;
    String hint;
    Integer position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("PROFILE");
        iv = (ImageView) findViewById(R.id.imageView3);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv5 = (TextView) findViewById(R.id.textView5);
        tv7 = (TextView) findViewById(R.id.textView7);
        tv9 = (TextView) findViewById(R.id.textView9);

        myBndl=getIntent().getExtras();
        if(myBndl==null){
            return;
        }
        hint = myBndl.getString("hint");
        iv.setImageResource(myBndl.getInt("imj"));
        tv3.setText(myBndl.getString("nm"));
        tv5.setText(myBndl.getString("dob"));
        tv7.setText(myBndl.getString("country"));
        tv9.setText(myBndl.getString("prof"));
        position=myBndl.getInt("pos");
    }

    //back button
    public void goBack(View view) {
        if(myBndl.getBoolean("flag")){
            Intent intent = new Intent(this, MenActivity.class);
            //hint="MenActivity";
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, WomenActivity.class);
            //hint="WomenActivity";
            startActivity(intent);
        }
    }

    public void gallery(View view) {
        Intent intent = new Intent(ProfileActivity.this, GalaryActivity.class);
        intent.putExtra("pos",position);
        intent.putExtra("hint", hint);
        intent.putExtra("name", myBndl.getString("nm"));
        //Toast.makeText(ProfileActivity.this,"pos",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.home){
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        }else {
            Intent intent=new Intent(this,ContactActivity.class);
            startActivity(intent);
        }
        return true;
    }
}