package com.example.hojan.fly2017_androidapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main_Calender extends AppCompatActivity {
    int point;
    DbOpenHelper mDbOpenHelper;
    Cursor mCursor;
    int nMonth;
    int nDay;
    TextView text;
    int db_check;
    String oldTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__calender);
        text = (TextView)findViewById(R.id.text1);

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


    private void init() {
        checkpermission();

        mDbOpenHelper = new DbOpenHelper(this);
        try {
            mDbOpenHelper = mDbOpenHelper.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mCursor = null;
        mCursor = mDbOpenHelper.getAll();
        try {
            while (mCursor.moveToNext()) {
                oldTime = mCursor.getString(0);
                point = mCursor.getInt(1);
                db_check = mCursor.getInt(2);
            }
            mCursor.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        text.setText(point+"점 입니다.");
    }

    public void onClick(View view) throws ParseException {
        if(view.getId() == R.id.absentButton){
            if(db_check == 10){
                //이전 디비랑 비교해서 날짜 확인하고 점수 주거나 안된다고 Toast띄우거나 하고 점수 안주면 디비 수정하기

                //이전에 저장해 둔 시간
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date_old = simpleDateFormat.parse(oldTime);

                //현재시간
                SimpleDateFormat simpleDateFormat_now = new SimpleDateFormat("yyyy-MM-dd");
                long now = System.currentTimeMillis();
                Date nowDate_ = new Date(now);
                String nowDate = simpleDateFormat_now.format(nowDate_);

                long rawResult = (date_old.getTime() - nowDate_.getTime()) /1000;
                long result = rawResult/(60*60*24);

                if(result <= 1){
                    //아직 안 지남_
                    Toast.makeText(getApplicationContext(), "아직 하루가 지나지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    //지남_10포인트 획득
                    point += 10;
                    mDbOpenHelper.UPDATE(oldTime,nowDate,point);
                    Log.d("남주", oldTime);
                    Log.d("남주", nowDate);
                    Toast.makeText(getApplicationContext(),"10 포인트 획득", Toast.LENGTH_SHORT).show();
                    text.setText(point + "점 입니다.");
                }

            }
            else{
                //처음 버튼 누를 때
                point = 0;
                point += 10;
                Toast.makeText(getApplicationContext(),"10 포인트 획득", Toast.LENGTH_SHORT).show();
                text.setText(point + "점 입니다.");
                //현재시간 확인
                oldTime = getDateString();
                mDbOpenHelper.INSERT(oldTime, point);
                db_check = 10;
            }
        }
    }

    public String getDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String str_date = df.format(new Date());

        return str_date;
    }

    public void checkpermission() {
        int permissioninfo = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissioninfo == PackageManager.PERMISSION_GRANTED) {
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "어플리케이션 설정에서 저장소 사용 권한을 허용해주세요", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
    }
}
