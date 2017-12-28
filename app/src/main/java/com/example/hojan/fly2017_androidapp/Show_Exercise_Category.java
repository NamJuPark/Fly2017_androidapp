package com.example.hojan.fly2017_androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Show_Exercise_Category extends AppCompatActivity {
    GridView gridView;
    Adapter_Show_Exercise_Category adapter;
    ArrayList<item_Exercise_Category> data = new ArrayList<item_Exercise_Category>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__exercise__category);
        init();
        moveToExercise();
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


    private void moveToExercise() {
        //각 카테고리 클릭했을 때 화면 전환
        intent = new Intent(this, Show_Exercise.class);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //스트레칭
                    intent.putExtra("category", 0);
                }
                else if(i == 1){
                    //팔
                    intent.putExtra("category", 1);
                }
                else if(i == 2){
                    //다리
                    intent.putExtra("category", 2);
                }
                else if(i == 3){
                    //가슴
                    intent.putExtra("category", 3);
                }
                else if(i == 4){
                    //어깨
                    intent.putExtra("category", 4);
                }
                else if(i == 5){
                    //복부
                    intent.putExtra("category", 5);
                }
                startActivity(intent);
            }
        });
    }

    private void init() {
        gridView = (GridView)findViewById(R.id.gridView);
        //어댑터생성
        adapter = new Adapter_Show_Exercise_Category(data,this);
        //어댑터와 그리드 뷰 연결
        gridView.setAdapter(adapter);
        data.add(new item_Exercise_Category(R.drawable.stretch));
        data.add(new item_Exercise_Category(R.drawable.arm));
        data.add(new item_Exercise_Category(R.drawable.leg));
        data.add(new item_Exercise_Category(R.drawable.chest));
        data.add(new item_Exercise_Category(R.drawable.shoulder));
        data.add(new item_Exercise_Category(R.drawable.valley));
        adapter.notifyDataSetChanged();

    }
}
