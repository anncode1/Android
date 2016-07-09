package com.anncode.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.myapplication.R;
import com.anncode.myapplication.model.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 09/07/16.
 */
public class ListTaskAdapter extends ArrayAdapter<Task>{
    Context context;
    int resource;
    ArrayList<Task> tasks;

    public ListTaskAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context    = context;
        this.resource   = resource;
        this.tasks      = tasks;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Activity activity = (Activity) context;

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(resource, null);

        ImageView imgImage      = (ImageView)    view.findViewById(R.id.imgImage);
        TextView  tvNameTask    = (TextView)     view.findViewById(R.id.tvNameTask);

        tvNameTask.setText(tasks.get(position).getName());

        //Picasso pone las imagenes desde internet al ImageView
        Picasso.with(activity)
                .load(tasks.get(position).getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(imgImage);

        return view;

    }


}
