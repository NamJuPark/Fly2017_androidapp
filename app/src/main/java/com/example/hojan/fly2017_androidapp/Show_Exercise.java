package com.example.hojan.fly2017_androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Show_Exercise extends AppCompatActivity {
    ListView listView;
    Adapter_Show_Exercise adapter;
    Intent intent;
    Intent intent_detail;
    int category;
    ArrayList<item_Exercise> exerciseData = new ArrayList<item_Exercise>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__exercise);
        init();
        moveTodetial();
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

    private void moveTodetial() {
        //여기 디테일로 보내는 거 만들기!!!!!
        intent_detail = new Intent(this, Show_Exercise_Detail.class);
        //여기 디테일로 보내는 거 만들기!!!!!

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent_detail.putExtra("exercise_detail",exerciseData.get(i));
                startActivity(intent_detail);
            }
        });
    }

    private void init() {
        listView = (ListView)findViewById(R.id.listView);
        //어뎁터 생성
        adapter = new Adapter_Show_Exercise(exerciseData,this);
        listView.setAdapter(adapter);
        //어떤 카테고리에 해당하는 화면 켤 지 확인
        intent = getIntent();
        category = intent.getIntExtra("category",0);
        if(category == 0){
            //스트레칭
            item_Exercise one = new item_Exercise(R.drawable.stretch_no_name, "스트레칭 1", "스트레칭 1입니다.","https://youtu.be/zppibOt2R3Y");
            item_Exercise two = new item_Exercise(R.drawable.stretch_no_name, "스트레칭 2", "스트레칭 2입니다.", "https://youtu.be/ez6xSbgagHY");

            exerciseData.add(one);
            exerciseData.add(two);
        }
        else if(category == 1){
            //팔
            item_Exercise one = new item_Exercise(R.drawable.arm_no_name, "아래팔", "아래팔입니다.", "https://youtu.be/pt9Yhi2WYoI");
            item_Exercise two = new item_Exercise(R.drawable.arm_no_name, "이두", "이두운동 입니다." , "https://youtu.be/U_d6_NbFa0c");
            item_Exercise thr = new item_Exercise(R.drawable.arm_no_name, "삼두", "삼두 운동 입니다." , "https://youtu.be/BS-2B43X44I");

            exerciseData.add(one);
            exerciseData.add(two);
            exerciseData.add(thr);

        }
        else if(category == 2){
            //다리
            item_Exercise one = new item_Exercise(R.drawable.leg_no_name, "종아리", "종아리 운동입니다." , "https://youtu.be/6_1_YildueM");
            item_Exercise two = new item_Exercise(R.drawable.leg_no_name, "허벅지", "허벅지 운동입니다.", "https://youtu.be/upU12lh-Gzo");

            exerciseData.add(one);
            exerciseData.add(two);

        }
        else if(category == 3){
            //가슴
            item_Exercise one = new item_Exercise(R.drawable.chest_no_name, "가슴 1", "가슴 1 운동입니다." , "https://youtu.be/2qwDBXg57ig");
            item_Exercise two = new item_Exercise(R.drawable.chest_no_name, "가슴 2", "가슴 2 운동입니다." , "https://youtu.be/tbmIq3FrBuw");

            exerciseData.add(one);
            exerciseData.add(two);

        }
        else if(category == 4){
            //어깨
            item_Exercise one = new item_Exercise(R.drawable.shoulder_no_name, "어깨", "어깨운동입니다." , "https://youtu.be/SAg5YaXzGAY");
            item_Exercise two = new item_Exercise(R.drawable.shoulder_no_name, "어깨 후면", "어깨 후면 운동입니다.", "https://youtu.be/Nf-x0779MvU");
            item_Exercise thr = new item_Exercise(R.drawable.shoulder_no_name, "어깨 3", "어깨 3 운동입니다." , "https://youtu.be/kZOBaAiCnfU");

            exerciseData.add(one);
            exerciseData.add(two);
            exerciseData.add(thr);
        }
        else if(category == 5){
            //복부
            item_Exercise one = new item_Exercise(R.drawable.vally_no_name, "복근", "복근운동입니다. ", "https://youtu.be/8IWif4gBAwA");
            item_Exercise two = new item_Exercise(R.drawable.vally_no_name, "복근 2", "복근2 입니다." ,"https://youtu.be/ZV9Hf_6mJYA");
            item_Exercise thr = new item_Exercise(R.drawable.vally_no_name, "코어", "코어 운동입니다." , "https://youtu.be/AqDHQ-sVV-4");

            exerciseData.add(one);
            exerciseData.add(two);
            exerciseData.add(thr);
        }
        adapter.notifyDataSetChanged();
    }
}