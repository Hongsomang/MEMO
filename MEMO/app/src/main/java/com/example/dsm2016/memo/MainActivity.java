package com.example.dsm2016.memo;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dsm2016 on 2017-07-24.0
 */

public class MainActivity extends AppCompatActivity{

    private DBHelper dbHelper;
    MemoListAdapter adapter;
    ListView lv;
    InputMethodManager imm;
    ImageButton reflesh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        reflesh=(ImageButton)findViewById(R.id.reflesh);

        Log.d("메인","화면");
        imm=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        findViewById(R.id.addmemo).setOnClickListener(clickListener);
        reflesh.setOnClickListener(refleshonClick);


    }

    View.OnClickListener refleshonClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                adapter=new MemoListAdapter();
                lv=(ListView)findViewById(R.id.memoListView);
                lv.setAdapter(adapter);
                while (true){
                    int i=1;

                    String title=dbHelper.select(i);
                    adapter.addItem(title,String.valueOf(new Date(System.currentTimeMillis())));
                    adapter.notifyDataSetChanged();

                    i++;
                    Log.d("리스트","추가");
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

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
