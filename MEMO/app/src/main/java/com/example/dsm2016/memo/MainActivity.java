package com.example.dsm2016.memo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by dsm2016 on 2017-07-24.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {
   private ImageButton memobtn;
   private EditText title;
    private  ListView listView;
    private ArrayList<String> mAalDate;
    private ArrayAdapter<String> mAaString;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ListViewAdapter adapter;
        adapter=new ListViewAdapter();
        listView=(ListView)findViewById(R.id.memoListView);
        listView.setAdapter(adapter);
        adapter.addItem(title,new Date(System.currentTimeMillis()));
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView parent,View v,int position,long id){
               ListViewItem item=(ListViewItem)parent.getItemAtPosition(position);
               String titleStr=item.getTitle();
               String dataStr=item.getDate();
           }


       });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
