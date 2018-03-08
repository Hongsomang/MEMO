package com.example.dsm2016.memo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.dsm2016.memo.Adapter.Main_Adapter;
import com.example.dsm2016.memo.iteam.RecyclerItemClickListener;
import com.example.dsm2016.memo.iteam.main_item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        initData();

    }
    private void initLayout(){
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

    }
    private void initData(){
        ArrayList<main_item> list=new ArrayList<>();
        list.add(new main_item("하하","2000-08-15"));

        Main_Adapter mainAdapter = new Main_Adapter(list);

        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
