package com.example.hojan.fly2017_androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show_Exercise_Category extends AppCompatActivity {
    GridView gridView;
    Adapter_Show_Exercise_Category adapter;
    ArrayList<item_Exercise_Category> data = new ArrayList<item_Exercise_Category>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__exercise__category);
        init();
        moveToExercise();
    }

    private void moveToExercise() {
        //각 카테고리 클릭했을 때 화면 전환
        //화면 전환은 다 같은 화면인데 해당 연결을 위해서
        // 어댑터가 다르게 적용하도록 해야하나...?
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //스트레칭
                    Toast.makeText(getApplicationContext(),"화면전환 0_스트레칭",Toast.LENGTH_SHORT).show();
                }
                else if(i == 1){
                    //팔
                    Toast.makeText(getApplicationContext(),"화면전환 1_",Toast.LENGTH_SHORT).show();
                }
                else if( i == 2){
                    //다리
                    Toast.makeText(getApplicationContext(),"화면전환 2",Toast.LENGTH_SHORT).show();
                }
                else if(i == 3){
                    //가슴
                    Toast.makeText(getApplicationContext(),"화면전환 3",Toast.LENGTH_SHORT).show();
                }
                else if(i == 4){
                    //어깨
                    Toast.makeText(getApplicationContext(),"화면전환 4",Toast.LENGTH_SHORT).show();
                }
                else if(i == 5){
                    //복부
                    Toast.makeText(getApplicationContext(),"화면전환 4",Toast.LENGTH_SHORT).show();
                }
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
