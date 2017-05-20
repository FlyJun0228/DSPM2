package com.example.administrator.dspm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */

public class NewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Bean> list;

    public NewAdapter(Context context, List<Bean> list){
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
        }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item,null);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.content = (TextView)convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.title.setText(list.get(position).getTitle());
            viewHolder.content.setText(list.get(position).getContent());
        }
        return convertView;
    }
    final class ViewHolder{
        private TextView title;
        private TextView content;
    }
}
