package com.example.dsm2016.memo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by dsm2016 on 2017-07-24.
 */

public class MemoListAdapter extends BaseAdapter implements View.OnClickListener {


    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public MemoListAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.date);
        Button button = (Button) convertView.findViewById(R.id.delete);
        button.setText("삭제");
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                listViewItemList.remove(pos);
                notifyDataSetChanged();
            }
        });
        ListViewItem listViewItem = listViewItemList.get(position);

        titleTextView.setText(listViewItem.getTitle());
        dateTextView.setText(listViewItem.getDate());
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(String title, String date) {
        ListViewItem item = new ListViewItem();
        item.setTitleStr(title);
        item.setDateStr(date);
        listViewItemList.add(item);
    }

}
