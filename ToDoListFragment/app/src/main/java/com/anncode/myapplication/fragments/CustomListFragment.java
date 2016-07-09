package com.anncode.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.anncode.myapplication.R;
import com.anncode.myapplication.adapter.ListTaskAdapter;
import com.anncode.myapplication.model.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomListFragment extends Fragment {


    public CustomListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_list, container, false);

        final EditText    edtTaskCustom  = (EditText) view.findViewById(R.id.edtTaskCustom);
        Button      btnTaskCustom  = (Button)   view.findViewById(R.id.btnTaskCustom);
        ListView    lstTaskCustom  = (ListView) view.findViewById(R.id.lstTaskCustom);

        final ArrayList<Task> tasks = new ArrayList<>();

        final ListTaskAdapter listTaskAdapter =
                new ListTaskAdapter(
                        getContext(),
                        R.layout.item_list,
                        tasks
                );

        lstTaskCustom.setAdapter(listTaskAdapter);

        btnTaskCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTask = edtTaskCustom.getText().toString();
                String imageTask = "http://icons.iconarchive.com/icons/dakirby309/simply-styled/128/OS-Android-icon.png";

                tasks.add(new Task(nameTask, imageTask));
                listTaskAdapter.notifyDataSetChanged();
                edtTaskCustom.setText("");
            }
        });


        lstTaskCustom.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                tasks.remove(position);
                listTaskAdapter.notifyDataSetChanged();
                return true;
            }
        });

        return view;
    }

}
