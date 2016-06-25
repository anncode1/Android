package com.anncode.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.anncode.fragments.model.Amigo;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


        Amigo amigo = (Amigo) getIntent().getExtras().getSerializable(getString(R.string.amigo));
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvTwitter = (TextView) findViewById(R.id.tvTwitter);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);

        tvNombre.setText(amigo.getNombre());
        tvTwitter.setText(amigo.getTwitter());
        tvTelefono.setText(amigo.getTelefono());

    }
}
