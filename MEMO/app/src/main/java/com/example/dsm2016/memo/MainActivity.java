package com.example.dsm2016.memo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
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

import static android.R.id.list;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by dsm2016 on 2017-07-24.0
 */

public class MainActivity extends AppCompatActivity {

    ListViewAdapter adapter;
    ListView lv;
    InputMethodManager imm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        adapter=new ListViewAdapter();
        lv=(ListView) findViewById(R.id.memoListView);
        lv.setAdapter(adapter);
        imm=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        findViewById(R.id.addmemo).setOnClickListener(clickListener);
    }
    private Button.OnClickListener clickListener =new Button.OnClickListener(){
        @Override
        public void onClick(final View v) {
            Intent intent=new Intent(getApplicationContext(),MemoActivity.class);
            startActivity(intent);
         /*   Context mContext = getApplicationContext();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.test, (ViewGroup) findViewById(R.id.layout_root));
            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);
            aDialog.setTitle("제목 입력");
            aDialog.setView(layout);

            aDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                EditText tittle=(EditText) layout.findViewById(R.id.test);
                    if(v.getId()==R.id.addmemo){
                        if (tittle.getText().length()!=0){
                            adapter.addItem(tittle.getText().toString(), String.valueOf(new Date(System.currentTimeMillis())));
                            tittle.setText("");
                            adapter.notifyDataSetChanged();
                            imm.hideSoftInputFromWindow(tittle.getWindowToken(),0);
                        }
                    }
                }
            });
            AlertDialog ad = aDialog.create();
            ad.show();*/

        }
    };


}
