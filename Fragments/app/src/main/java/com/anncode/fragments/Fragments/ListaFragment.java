package com.anncode.fragments.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.anncode.fragments.R;
import com.anncode.fragments.model.Amigo;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {


    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lista, container, false);
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        final ListView lstAmigos = (ListView) view.findViewById(R.id.lstAmigos);
        lstAmigos.setAdapter(new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1,
                setUpListAmigosDummy()));

        lstAmigos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Amigo amigo = (Amigo) lstAmigos.getAdapter().getItem(position);



            }
        });


        return view;
    }

    public Amigo[] setUpListAmigosDummy(){

        Amigo[] amigos = {
                new Amigo("Julio Lara", "@julio", "999922222"),
                new Amigo("Tania Corona", "@tania", "877773333"),
                new Amigo("Francisco Perez", "@paco", "66662222")
        };



        return amigos;
    }

}
