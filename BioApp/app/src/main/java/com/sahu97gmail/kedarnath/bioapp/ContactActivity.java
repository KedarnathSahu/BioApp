package com.sahu97gmail.kedarnath.bioapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ib=(ImageButton) findViewById(R.id.linkedin);
        TextView feedback = (TextView) findViewById(R.id.textViewE1);
        feedback.setText(Html.fromHtml("<font color=#006699>"+"<a href=\"mailto:contact.kedarnath@gmail.com\">contact.kedarnath@gmail.com</a>"+"</font>"));
        feedback.setMovementMethod(LinkMovementMethod.getInstance());
        TextView feedback2 = (TextView) findViewById(R.id.textViewE2);
        feedback2.setText(Html.fromHtml("<font color=#006699>"+"<a href=\"mailto:www.devpriya.143@gmail.com\">www.devpriya.143@gmail.com</a>"+"</font>"));
        feedback2.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void mOpen(View view){
        Uri uri = Uri.parse("http://www.linkedin.com/in/kedarnathsahu"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.home2){
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
        return true;
    }
}