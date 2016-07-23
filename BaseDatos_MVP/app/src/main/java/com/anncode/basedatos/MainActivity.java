package com.anncode.basedatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.anncode.basedatos.db.DataBaseAdapter;
import com.anncode.basedatos.view.ListaContactosActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtEmail;
    EditText edtTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName     = (EditText) findViewById(R.id.edtName);
        edtEmail    = (EditText) findViewById(R.id.edtEmail);
        edtTwitter  = (EditText) findViewById(R.id.edtTwitter);


    }



    public void showSnackBar(View view){
        Snackbar.make(view,"Se insertó con éxito",Snackbar.LENGTH_LONG)
                .setAction("Aceptar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =
                                new Intent(
                                        MainActivity.this,
                                        ListaContactosActivity.class
                                );
                        startActivity(intent);

                    }
                }).show();
    }


}
