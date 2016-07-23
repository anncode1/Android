package com.anncode.basedatos.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.anncode.basedatos.interactor.ListaContactosActivityInteractorDB;
import com.anncode.basedatos.view.IListaContactosActivity;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 23/07/16.
 */
public class ListaContactosActivityPresenter implements IListaContactosActivityPresenter {

    IListaContactosActivity iListaContactosActivity;
    Context context;

    public ListaContactosActivityPresenter(IListaContactosActivity iListaContactosActivity, Context context) {
        this.iListaContactosActivity = iListaContactosActivity;
        this.context = context;
        getData();
    }

    //Fuente de Datos
    @Override
    public void getData() {
        ArrayList<String> nombresContacto = new ArrayList<>();

        ListaContactosActivityInteractorDB
                listaContactosActivityInteractorDB =
                new ListaContactosActivityInteractorDB(context);

        nombresContacto =
                listaContactosActivityInteractorDB.getNombresContacto();

        showData(nombresContacto);
    }

    @Override
    public void showData(ArrayList<String> nombresContacto) {
        ArrayAdapter<String> adapter =
                iListaContactosActivity.createAdapter(nombresContacto);
        iListaContactosActivity.setAdapterListView(adapter);
    }
}
