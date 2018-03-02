package com.sahu97gmail.kedarnath.bioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GalaryActivity extends AppCompatActivity {
    int[][] m_images ={{R.drawable.m1_1,R.drawable.m1_2,R.drawable.m1_3,R.drawable.m1_4,R.drawable.m1_5,R.drawable.m1_6,R.drawable.m1_7,R.drawable.m1_8},
            {R.drawable.m2_1,R.drawable.m2_2,R.drawable.m2_3,R.drawable.m2_4,R.drawable.m2_5,R.drawable.m2_6,R.drawable.m2_7,R.drawable.m2_8},
            {R.drawable.m3_1,R.drawable.m3_2,R.drawable.m3_3,R.drawable.m3_4,R.drawable.m3_5,R.drawable.m3_6,R.drawable.m3_7,R.drawable.m3_8},
            {R.drawable.m4_1,R.drawable.m4_2,R.drawable.m4_3,R.drawable.m4_4,R.drawable.m4_5,R.drawable.m4_6,R.drawable.m4_7,R.drawable.m4_8},
            {R.drawable.m5_1,R.drawable.m5_2,R.drawable.m5_3,R.drawable.m5_4,R.drawable.m5_5,R.drawable.m5_6,R.drawable.m5_7,R.drawable.m5_8},
            {R.drawable.m6_1,R.drawable.m6_2,R.drawable.m6_3,R.drawable.m6_4,R.drawable.m6_5,R.drawable.m6_6,R.drawable.m6_7,R.drawable.m6_8},
            {R.drawable.m7_1,R.drawable.m7_2,R.drawable.m7_3,R.drawable.m7_4,R.drawable.m7_5,R.drawable.m7_6,R.drawable.m7_7,R.drawable.m7_8},
            {R.drawable.m8_1,R.drawable.m8_2,R.drawable.m8_3,R.drawable.m8_4,R.drawable.m8_5,R.drawable.m8_6,R.drawable.m8_7,R.drawable.m8_8}};
    int[][] f_images = {{R.drawable.f1_1,R.drawable.f1_2,R.drawable.f1_3,R.drawable.f1_4,R.drawable.f1_5,R.drawable.f1_6,R.drawable.f1_7,R.drawable.f1_8},
            {R.drawable.f2_1,R.drawable.f2_2,R.drawable.f2_3,R.drawable.f2_4,R.drawable.f2_5,R.drawable.f2_6,R.drawable.f2_7,R.drawable.f2_8},
            {R.drawable.f3_1,R.drawable.f3_2,R.drawable.f3_3,R.drawable.f3_4,R.drawable.f3_5,R.drawable.f3_6,R.drawable.f3_7,R.drawable.f3_8},
            {R.drawable.f4_1,R.drawable.f4_2,R.drawable.f4_3,R.drawable.f4_4,R.drawable.f4_5,R.drawable.f4_6,R.drawable.f4_7,R.drawable.f4_8},
            {R.drawable.f5_1,R.drawable.f5_2,R.drawable.f5_3,R.drawable.f5_4,R.drawable.f5_5,R.drawable.f5_6,R.drawable.f5_7,R.drawable.f5_8},
            {R.drawable.f6_1,R.drawable.f6_2,R.drawable.f6_3,R.drawable.f6_4,R.drawable.f6_5,R.drawable.f6_6,R.drawable.f6_7,R.drawable.f6_8},
            {R.drawable.f7_1,R.drawable.f7_2,R.drawable.f7_3,R.drawable.f7_4,R.drawable.f7_5,R.drawable.f7_6,R.drawable.f7_7,R.drawable.f7_8},
            {R.drawable.f8_1,R.drawable.f8_2,R.drawable.f8_3,R.drawable.f8_4,R.drawable.f8_5,R.drawable.f8_6,R.drawable.f8_7,R.drawable.f8_8}};
    GridView gv;
    ProfileActivity pa=new ProfileActivity();
    String hint,name;
    Integer position;//row
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galary);
        getSupportActionBar().setTitle("GALLERY");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);//has issues!
        position=getIntent().getExtras().getInt("pos");
        gv=(GridView)findViewById(R.id.gridView);
        hint = getIntent().getExtras().getString("hint");
        name=getIntent().getExtras().getString("name");
        UniversalAdapter ua=new UniversalAdapter(getApplicationContext(),m_images,f_images,position,hint);
        gv.setAdapter(ua);
        ImageView iv1=(ImageView)findViewById(R.id.imageView4);
        TextView tv=(TextView)findViewById(R.id.textView10);
        if(hint.equalsIgnoreCase("MenActivity")){
            iv1.setImageResource(m_images[position][0]);
            tv.setText(name);
        }else {
            iv1.setImageResource(f_images[position][0]);
            tv.setText(name);
        }
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
