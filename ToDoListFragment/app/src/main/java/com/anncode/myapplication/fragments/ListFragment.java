package com.anncode.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.anncode.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }

    ArrayList<String> tasks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        final EditText edtTask    = (EditText)    view.findViewById(R.id.edtTask);
        Button btnTask      = (Button)      view.findViewById(R.id.btnTask);
        ListView lstTask    = (ListView)    view.findViewById(R.id.lstTask);


         tasks= new ArrayList<>();
         final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        tasks
                );

        lstTask.setAdapter(adapter);

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = edtTask.getText().toString();
                tasks.add(task);
                adapter.notifyDataSetChanged();
                edtTask.setText("");
            }
        });



        return view;
    }

}
