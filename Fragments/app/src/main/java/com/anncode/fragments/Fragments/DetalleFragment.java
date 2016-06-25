package com.anncode.fragments.Fragments;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anncode.fragments.R;
import com.anncode.fragments.model.Amigo;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {


    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
        /*View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        TextView tvNombre = (TextView) view.findViewById(R.id.tvNombre);
        TextView tvTwitter = (TextView) view.findViewById(R.id.tvTwitter);
        TextView tvTelefono = (TextView) view.findViewById(R.id.tvTelefono);


        if (getActivity().getIntent().getExtras() != null){
            //Amigo amigo = (Amigo) getArguments().getSerializable(getString(R.string.amigo));
            Bundle parametros = getActivity().getIntent().getExtras();
            String nombre = parametros.getString(getString(R.string.amigo));
            tvNombre.setText(nombre);
            //tvTwitter.setText(amigo.getTwitter());
            //tvTelefono.setText(amigo.getTelefono());

        }

        return view;*/
    }

    @Override
    public void onResume() {
        Log.e("RESUME", "resumen");
        super.onResume();
    }
}
