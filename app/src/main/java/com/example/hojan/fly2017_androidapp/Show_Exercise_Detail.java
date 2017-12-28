package com.example.hojan.fly2017_androidapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_Exercise_Detail extends AppCompatActivity {
    Intent intent_detail, intent_URL, intent_Camera;
    ImageView camera;
    ImageView img;
    item_Exercise one;
    TextView title, caption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__exercise__detail);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_move_other_acrivity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent_menu;
        if(item.getItemId() == R.id.menu_Home){
            intent_menu = new Intent(this,Main_Calender.class);
            startActivity(intent_menu);
        }
        else if(item.getItemId() == R.id.menu_Exercise){
            intent_menu = new Intent(this, Show_Exercise_Category.class);
            startActivity(intent_menu);
        }
        else if(item.getItemId() == R.id.menu_Community){
            intent_menu = new Intent(this, Community.class);
            startActivity(intent_menu);
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View v){
        if(v.getId() == R.id.exerImg){
            intent_URL = new Intent(Intent.ACTION_VIEW, Uri.parse(one.exerLink));
            startActivity(intent_URL);
        }
        else if(v.getId() == R.id.camera){
            intent_Camera = new Intent(this, Show_Exercise_Pose.class);
            startActivity(intent_Camera);
        }
    }

    private void init() {
        intent_detail = getIntent();
        one = intent_detail.getParcelableExtra("exercise_detail");

        img = (ImageView) findViewById(R.id.exerImg);
        camera = (ImageView) findViewById(R.id.camera);
        title = (TextView)findViewById(R.id.title);
        caption = (TextView)findViewById(R.id.caption);

        title.setText(one.exerName);
        caption.setText(one.exerCaption);

    }


}
