package com.example.dsm2016.memo.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dsm2016.memo.MemoActivity;
import com.example.dsm2016.memo.R;
import com.example.dsm2016.memo.iteam.main_item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm2016 on 2018-03-06.
 */

public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.ViewHolder> {
    private ArrayList<main_item> list;
    private  int itemLayout;
    public Main_Adapter(ArrayList<main_item> items){
        this.list=items;
    }
    @Override
    public Main_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        main_item item=list.get(position);
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textday.setText(item.getDay());
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle;
        public TextView textday;
        public ViewHolder(View itemView) {
            super(itemView);
            textTitle=(TextView)itemView.findViewById(R.id.title);
            textday=(TextView)itemView.findViewById(R.id.day);
        }


    }



}


