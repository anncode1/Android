package com.anncode.basedatos.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.anncode.basedatos.MainActivity;
import com.anncode.basedatos.R;
import com.anncode.basedatos.db.DataBaseAdapter;
import com.anncode.basedatos.presenter.IListaContactosActivityPresenter;
import com.anncode.basedatos.presenter.ListaContactosActivityPresenter;

import java.util.ArrayList;

public class ListaContactosActivity extends AppCompatActivity implements IListaContactosActivity {

    ListView lstContactos;
    FloatingActionButton  fabAddContact;
    IListaContactosActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabAddContact = (FloatingActionButton) findViewById(R.id.fabAddContact);
        lstContactos = (ListView) findViewById(R.id.lstContactos);
        setUpFAB();
        presenter = new ListaContactosActivityPresenter(this, getBaseContext());
    }

    @Override
    public void setUpFAB() {
        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent =
                        new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public ArrayAdapter<String> createAdapter(ArrayList<String> nombresContacto) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        ListaContactosActivity.this,
                        android.R.layout.simple_list_item_1,
                        nombresContacto
                );
        return adapter;
    }

    @Override
    public void setAdapterListView(ArrayAdapter<String> adapter) {
        lstContactos.setAdapter(adapter);
    }
}
