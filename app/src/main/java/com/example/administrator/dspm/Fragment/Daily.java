package com.example.administrator.dspm.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.dspm.Cuns;
import com.example.administrator.dspm.MyAdapter;
import com.example.administrator.dspm.MyDataBase;
import com.example.administrator.dspm.R;
import com.example.administrator.dspm.SecondAtivity;

import java.util.ArrayList;


public class Daily extends Fragment {
    Button bt;
    ListView lv;
    LayoutInflater inflater;
    ArrayList<Cuns> array;
    MyDataBase mdb;
    Bundle savedInstanceState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note, container, false);
        lv=(ListView)view.findViewById(R.id.listView1);
        bt=(Button)view.findViewById(R.id.button1);
        inflater =getLayoutInflater(savedInstanceState);

        mdb=new MyDataBase(getActivity());
        array=mdb.getArray();
        MyAdapter adapter=new MyAdapter(inflater,array);
        lv.setAdapter(adapter);
        initlistener();
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent=new Intent(getContext(),SecondAtivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.item2:
                getActivity().finish();
                break;
            default:
                break;
        }
        return true;

    }
    public void initlistener() {
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           final int position, long id) {
                // TODO Auto-generated method stub

                new AlertDialog.Builder(getContext())
                        .setTitle("ɾ��")
                        .setMessage("�Ƿ�ɾ���ʼ�")
                        .setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub

                            }
                        })
                        .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                mdb.toDelete(array.get(position).getIds());
                                array = mdb.getArray();
                                MyAdapter adapter = new MyAdapter(inflater, array);
                                lv.setAdapter(adapter);
                            }
                        })
                        .create().show();
                return true;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(getContext(),SecondAtivity.class);
                intent.putExtra("ids",array.get(position).getIds() );
                startActivity(intent);
                getActivity().finish();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(getContext(),SecondAtivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


}
