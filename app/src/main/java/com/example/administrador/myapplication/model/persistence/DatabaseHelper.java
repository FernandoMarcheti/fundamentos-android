package com.example.administrador.myapplication.model.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrador.myapplication.model.entities.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "MY_DATABASE";
    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DatabaseHelper.BANCO_DADOS, null, DatabaseHelper.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        User user = new User();
        user.setUser("admin");
        user.setPassword("admin");
        db.execSQL(UserContract.getCreateSql());
        db.execSQL(String.valueOf(UserContract.insertUser(user)));
        db.execSQL(ClientContract.getCreateSql());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createUser(SQLiteDatabase db) {

    }

}
