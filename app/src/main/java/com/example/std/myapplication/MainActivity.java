package com.example.std.myapplication;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView mListView;

    Intent mIntent;

    String[] songNames = {"MIC Drop - BTS", "หน้าหนาวที่แล้ว - THE TOYS", "จดหมาย - THE TOYS"};
    int[] songPic = {R.drawable.micdrop, R.drawable.toys1, R.drawable.toys2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, songNames, songPic);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent mIntent = new Intent(view.getContext(),Main2Activity.class);
                    mIntent.putExtra("songName", songNames[i]);
                    mIntent.putExtra("songPic", songPic[i]);
                    startActivityForResult(mIntent,0);
                }
                if(i==1){
                    Intent mIntent = new Intent(view.getContext(),Main3Activity.class);
                    mIntent.putExtra("songName", songNames[i]);
                    mIntent.putExtra("songPic", songPic[i]);
                    startActivityForResult(mIntent,1);
                }
                if(i==2){
                    Intent mIntent = new Intent(view.getContext(),Main4Activity.class);
                    mIntent.putExtra("songName", songNames[i]);
                    mIntent.putExtra("songPic", songPic[i]);
                    startActivityForResult(mIntent,2);
                }


            }
        });
    }

    }








