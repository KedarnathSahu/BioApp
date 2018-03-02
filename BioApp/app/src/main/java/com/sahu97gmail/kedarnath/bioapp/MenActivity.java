package com.sahu97gmail.kedarnath.bioapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenActivity extends AppCompatActivity {

    Integer[] images = {R.drawable.m1_1, R.drawable.m2_1, R.drawable.m3_1, R.drawable.m4_1, R.drawable.m5_1, R.drawable.m6_1, R.drawable.m7_1, R.drawable.m8_1};
    String[] NAMES = {"Aamir Khan", "Hrithik Rosha", "John Abraham", "MS Dhoni", "Salman Khan", "Tiger Shroff", "Varun Dhawan", "Virat Kohli"};
    String[] Country = {"india", "india", "india", "india", "india", "india", "india", "india"};
    String[] DOB = {"14 March 1965","10 Jan 1974","17 Dec 1972","7 July 1981","27 Dec 1965","2 March 1990","24 April 1987","5 Nov 1988"};
    String[] Prof = {"Actor","Actor","Actor","Cricketer","Actor","Actor","Actor","Cricketer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        getSupportActionBar().setTitle("MEN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListAdapter customListAdapter = new ProfileAdapter(this,NAMES);// Pass the NAMES array to the constructor.
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customListAdapter);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(MenActivity.this,ProfileActivity.class);
                        intent.putExtra("imj",images[position]);
                        intent.putExtra("nm",NAMES[position]);
                        intent.putExtra("dob",DOB[position]);
                        intent.putExtra("country",Country[position]);
                        intent.putExtra("prof",Prof[position]);
                        intent.putExtra("flag", true);
                        intent.putExtra("pos",position);
                        intent.putExtra("hint", "MenActivity");
                        String name = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MenActivity.this, name, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
        );
    }

    public class ProfileAdapter extends ArrayAdapter<String> {
        public ProfileAdapter(@NonNull Context context, String[] names) {
            super(context, R.layout.profile ,names);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
            View view = myCustomInflater.inflate(R.layout.profile, parent, false);
            ImageView iv = (ImageView) view.findViewById(R.id.imageView2);
            TextView tv1 = (TextView) view.findViewById(R.id.text1);
            TextView tv2 = (TextView) view.findViewById(R.id.text2);
            iv.setImageResource(images[position]);
            tv1.setText(NAMES[position]);
            tv2.setText(Country[position]);
            return view;
        }
    }
}