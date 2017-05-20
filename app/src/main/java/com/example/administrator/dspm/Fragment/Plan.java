package com.example.administrator.dspm.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.administrator.dspm.R;


public class Plan extends Fragment implements View.OnClickListener {

    boolean q,w,e,a,s;

    private Button mBtnSave;

    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
    private EditText editText1,editText2,editText3,editText4,editText5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_plan,container,false);
        initView(view);
        initListener();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        ShowText(editText1,"plan1");
        ShowText(editText2,"plan2");
        ShowText(editText3,"plan3");
        ShowText(editText4,"plan4");
        ShowText(editText5,"plan5");

        return view;
    }
    public void initView(View view) {
        mBtnSave = (Button) view.findViewById(R.id.save);
        editText1 = (EditText) view.findViewById(R.id.plan1);
        editText2 = (EditText) view.findViewById(R.id.plan2);
        editText3 = (EditText) view.findViewById(R.id.plan3);
        editText4 = (EditText) view.findViewById(R.id.plan4);
        editText5 = (EditText) view.findViewById(R.id.plan5);
        checkBox1 = (CheckBox) view.findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox) view.findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox) view.findViewById(R.id.checkbox4);
        checkBox5 = (CheckBox) view.findViewById(R.id.checkbox5);

    }
    public void initListener(){
        mBtnSave.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                editor = sharedPreferences.edit();
                editor.putString("plan1",editText1.getText().toString());
                editor.putString("plan2",editText2.getText().toString());
                editor.putString("plan3",editText3.getText().toString());
                editor.putString("plan4",editText4.getText().toString());
                editor.putString("plan5",editText5.getText().toString());
                editor.commit();
                Checkbox(checkBox1,"plan1");
                Checkbox(checkBox2,"plan2");
                Checkbox(checkBox3,"plan3");
                Checkbox(checkBox4,"plan4");
                Checkbox(checkBox5,"plan5");

                break;
        }
    }
    public void ShowText(EditText editText, String plan){
        editText.setText(sharedPreferences.getString(plan, ""));
    }
    public boolean Check(CheckBox checkBox){
        boolean isChecked = checkBox.isChecked();
        return isChecked;
    }
    public void Checkbox(CheckBox box, String plan){
        if (box.isChecked()){
            editor.remove(plan).commit();
        }
    }
}
