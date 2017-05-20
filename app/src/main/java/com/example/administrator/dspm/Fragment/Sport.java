package com.example.administrator.dspm.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.dspm.R;

import java.util.Timer;
import java.util.TimerTask;



public class Sport extends Fragment implements View.OnClickListener{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button mBtnAdd,mBtnZero;
    private TextView mTvDays;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sport,container,false);
        initView(view);
        initListener();
        sharedPreferences = getContext().getSharedPreferences("Days", Context.MODE_PRIVATE);
        int day = sharedPreferences.getInt("days",0);
        mTvDays.setText(Integer.toString(day));
        return view;
    }
    public void initView(View view){
        mBtnAdd = (Button)view.findViewById(R.id.id_add);
        mBtnZero = (Button)view.findViewById(R.id.id_zero);
        mTvDays = (TextView)view.findViewById(R.id.id_days);
    }
    public void initListener(){
        mBtnZero.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        sharedPreferences = getContext().getSharedPreferences("Days", Context.MODE_PRIVATE);
        int day = sharedPreferences.getInt("days",0);
        switch (v.getId()){
            case R.id.id_add:
                day++;
                editor = (SharedPreferences.Editor)getContext().getSharedPreferences("Days", Context.MODE_PRIVATE).edit();
                editor.putInt("days",day);
                editor.commit();
                mTvDays.setText(Integer.toString(day));
               // time();
                break;
            case R.id.id_zero:
                day = 0;
                editor = (SharedPreferences.Editor)getContext().getSharedPreferences("Days", Context.MODE_PRIVATE).edit();
                editor.putInt("days",day);
                editor.commit();
                mTvDays.setText(Integer.toString(day));
                break;
        }
    }
    public void time() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int day = 0;
                editor = (SharedPreferences.Editor) getContext().getSharedPreferences("Days", Context.MODE_PRIVATE).edit();
                editor.putInt("days", day);
                editor.commit();
                mTvDays.setText(Integer.toString(day));
            }
        };
        timer.schedule(timerTask,1000*300);
    }
}
