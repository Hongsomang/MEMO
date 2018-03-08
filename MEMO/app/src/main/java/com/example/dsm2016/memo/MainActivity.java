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
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getApplicationContext(),MemoActivity.class);
                startActivity(intent);

            }

            @Override
            public void onLogItemClick(View view, int position) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(getApplication());
                builder.setTitle("삭제")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_LONG).show();

                            }
                        });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
            }
        }));
    }
    private void initData(){
        ArrayList<main_item> list=new ArrayList<>();
        list.add(new main_item("병신","2000-08-15"));

        Main_Adapter mainAdapter = new Main_Adapter(list);

        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
