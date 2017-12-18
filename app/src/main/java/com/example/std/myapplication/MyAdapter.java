package com.example.std.myapplication;


import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import static android.R.attr.resource;

public class MyAdapter extends ArrayAdapter<String> {

    int[] image;
    String[] name;
    Context mContext;





    public MyAdapter(Context context, String[] songNames, int[] songPic) {
        super(context, R.layout.listview_item);
        this.name = songNames;
        this.image = songPic;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }





    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mPic = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mPic.setImageResource(image[position]);
        mViewHolder.mName.setText(name[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView mPic;
        TextView mName;
    }
}
