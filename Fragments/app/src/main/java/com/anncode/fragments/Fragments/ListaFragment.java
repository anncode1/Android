package com.anncode.fragments.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.anncode.fragments.DetalleActivity;
import com.anncode.fragments.R;
import com.anncode.fragments.model.Amigo;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {


    public ListaFragment() {
        // Required empty public constructor
    }

    public static final int ORIENTATION_PORTRAIT = 1;
    public static final int ORIENTATION_LANSCAPE = 2;

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

                if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT){
                    Intent i = new Intent(getContext(), DetalleActivity.class);
                    i.putExtra(getString(R.string.amigo), amigo);
                    startActivity(i);
                }else if (getResources().getConfiguration().orientation == ORIENTATION_LANSCAPE){
                    DetalleFragment detalleFragment = (DetalleFragment)
                            getFragmentManager().findFragmentById(R.id.frgDetalle);
                    TextView tvNombre = (TextView)
                            detalleFragment.getView().findViewById(R.id.tvNombre);
                    TextView tvTwitter = (TextView)
                            detalleFragment.getView().findViewById(R.id.tvTwitter);
                    TextView tvTelefono = (TextView)
                            detalleFragment.getView().findViewById(R.id.tvTelefono);

                    tvNombre.setText(amigo.getNombre());
                    tvTwitter.setText(amigo.getTwitter());
                    tvTelefono.setText(amigo.getTelefono());

                }


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
