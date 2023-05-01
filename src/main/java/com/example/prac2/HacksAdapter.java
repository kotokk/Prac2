package com.example.prac2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HacksAdapter extends ArrayAdapter<HacksList> {

    private Context mContext;
    private int mResourse;

    public HacksAdapter(@NonNull Context context, int resource, @NonNull ArrayList<HacksList> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResourse = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResourse, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.text_hacks);

        imageView.setImageResource(getItem(position).getImage());
        textView.setText(getItem(position).getTitle());

        return convertView;
    }
}
