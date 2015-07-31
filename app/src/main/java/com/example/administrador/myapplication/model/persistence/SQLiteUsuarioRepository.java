package com.example.administrador.myapplication.model.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.myapplication.model.entities.User;
import com.example.administrador.myapplication.util.AppUtil;

/**
 * Created by Administrador on 30/07/2015.
 */
public class SQLiteUsuarioRepository implements UserRepository {

    private static SQLiteUsuarioRepository singletonInstance;

    private SQLiteUsuarioRepository() {
        super();
    }

    public static UserRepository getInstance(){

        if (SQLiteUsuarioRepository.singletonInstance == null) {
            SQLiteUsuarioRepository.singletonInstance = new SQLiteUsuarioRepository();
        }

        return SQLiteUsuarioRepository.singletonInstance;
    }

    @Override
    public User get() {
        DatabaseHelper helper = new DatabaseHelper(AppUtil.CONTEXT);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(UserContract.TABLE, UserContract.COLUMNS, null, null, null, null, UserContract.USER);

        User user = UserContract.bind(cursor);

        db.close();
        helper.close();
        return user;
    }
}
