package com.example.hojan.fly2017_androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Community extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        WebView webView = (WebView) findViewById(R.id.wedView);
        WebSettings webSettings = webView.getSettings();
        // 자바스크립트 사용하기
        webSettings.setJavaScriptEnabled(true);
        // WebView 내장 Zoom 사용
        webSettings.setBuiltInZoomControls(true);
        // 확대,축소 기능을 사용할 수 있도록 설정
        webSettings.setSupportZoom(true);
        // 캐쉬 사용 방법을 정의(default : LOAD_DEFAULT)
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.loadUrl("http://kkingkkang.dothome.co.kr/");
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
}
