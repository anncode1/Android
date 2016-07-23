package com.anncode.basedatos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.anncode.basedatos.model.Contacto;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 16/07/16.
 */
public class DataBaseAdapter extends SQLiteOpenHelper {

    public DataBaseAdapter(Context context) {
        super(context, "miBaseDatos", null, 1);
    }

    public ArrayList<Contacto> getAllContacts(){
        ArrayList<Contacto> contactos = new ArrayList<>();
        String query = "SELECT * FROM user";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Contacto currentContact = new Contacto();
            currentContact.setId(registros.getInt(0));
            currentContact.setNombre(registros.getString(1));
            currentContact.setEmail(registros.getString(2));
            currentContact.setTwitter(registros.getString(3));

            contactos.add(currentContact);
        }

        db.close();
        return contactos;
    }

    public void insertContact(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("user", null, contentValues);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, twitter TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
