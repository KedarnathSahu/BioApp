package com.sahu97gmail.kedarnath.bioapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WomenActivity extends AppCompatActivity {

    Integer[] images = {R.drawable.f1_1, R.drawable.f2_1, R.drawable.f3_1, R.drawable.f4_1, R.drawable.f5_1, R.drawable.f6_1, R.drawable.f7_1, R.drawable.f8_1};
    String[] NAMES = {"Aishwarya Rai","Alia Bhatt","Anushka Sharma","Deepika Padukone","Katrina Kaif","Mithali Raj","Priyanka Chopra","Saina Nehwal"};
    String[] Country = {"india", "india", "india", "india", "india", "india", "india", "india"};
    String[] DOB = {"1 Nov 1973","15 March 1993","1 May 1988","5 Jan 1986","16 July 1983","3 Dec 1982","18 July 1982","17 March 1990"};
    String[] Prof = {"Actress","Actress","Actress","Actress","Actress","Cricketer","Actress","Badminton Player"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
        getSupportActionBar().setTitle("WOMEN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListAdapter customListAdapter = new ProfileAdapter(this,NAMES);// Pass the NAMES array to the constructor.
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(customListAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(WomenActivity.this, ProfileActivity.class);
                        intent.putExtra("imj",images[position]);
                        intent.putExtra("nm",NAMES[position]);
                        intent.putExtra("dob",DOB[position]);
                        intent.putExtra("country",Country[position]);
                        intent.putExtra("prof",Prof[position]);
                        intent.putExtra("flag", false);
                        intent.putExtra("pos",position);
                        intent.putExtra("hint", "WomenActivity");
                        String name = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(WomenActivity.this, name, Toast.LENGTH_SHORT).show();
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