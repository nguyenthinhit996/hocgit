package com.example.tuan05;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuan05.pojo.Student;

import java.util.ArrayList;

public class ListItemAdapter extends BaseAdapter {
    protected ArrayList<Student> listItem;

    protected ListItemAdapter(ArrayList<Student> listItem) {
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listItem.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewItem;
        if (view == null) {
            viewItem = View.inflate(viewGroup.getContext(), R.layout.item, null);

        } else {
            viewItem = view;
        }

        Student item = (Student) getItem(position);
        ((TextView) viewItem.findViewById(R.id.txtIDStudent)).setText(String.format("%s", item.getId()));
        ((ImageView) viewItem.findViewById(R.id.imgAvatar)).setImageResource(item.getImgAvt());

        return viewItem;
    }
}