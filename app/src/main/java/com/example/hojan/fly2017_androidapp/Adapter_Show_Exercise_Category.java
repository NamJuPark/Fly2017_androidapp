package com.example.hojan.fly2017_androidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by 박남주 on 2017-08-12.
 */

public class Adapter_Show_Exercise_Category extends BaseAdapter{
    ArrayList<item_Exercise_Category> data;
    Context context;
    public Adapter_Show_Exercise_Category(ArrayList<item_Exercise_Category> data, Context context){
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) view = LayoutInflater.from(context).inflate(R.layout.item_show_exercise_category,null);
        item_Exercise_Category one = data.get(i);

        ImageView imege = (ImageView)view.findViewById(R.id.imageView);

        imege.setImageResource(one.imgno);

        return view;
    }
}
