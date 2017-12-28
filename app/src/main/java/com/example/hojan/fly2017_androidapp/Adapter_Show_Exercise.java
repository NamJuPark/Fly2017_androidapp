package com.example.hojan.fly2017_androidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 박남주 on 2017-08-27.
 */


public class Adapter_Show_Exercise extends BaseAdapter {
    ArrayList<item_Exercise> exerciseData;
    Context context;
    public Adapter_Show_Exercise(ArrayList<item_Exercise>exerciseData, Context context){
        this.exerciseData = exerciseData;
        this.context = context;
    }
    @Override
    public int getCount() {
        return exerciseData.size();
    }

    @Override
    public Object getItem(int i) {
        return exerciseData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) view = LayoutInflater.from(context).inflate(R.layout.item_show_exercise,null);
        item_Exercise one = exerciseData.get(i);

        ImageView img = (ImageView)view.findViewById(R.id.ivExercise);
        TextView tvName = (TextView) view.findViewById(R.id.textView);

        img.setImageResource(exerciseData.get(i).exerno);
        tvName.setText(exerciseData.get(i).exerName.toString());

        return view;
    }
}
