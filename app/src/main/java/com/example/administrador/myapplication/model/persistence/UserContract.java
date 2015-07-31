package com.example.administrador.myapplication.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.myapplication.model.entities.User;

public class UserContract {

    public static final String TABLE = "user";
    public static final String ID = "id";
    public static final String USER = "user";
    public static final String PASSWORD = "password";

    public static final String[] COLUMNS = {ID, USER, PASSWORD};

    public static String getCreateSql() {
        StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(ID + " INTEGER PRIMARY KEY, ");
        sql.append(USER + " TEXT, ");
        sql.append(PASSWORD + " TEXT ");
        sql.append(" ) ");

        return sql.toString();
    }

    public static String insertUser(User user) {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(USER + ", ");
        sql.append(PASSWORD);
        sql.append(" ) ");

        sql.append(" VALUES ");
        sql.append(" ( ");
        sql.append(" '" + user.getUser() + "', ");
        sql.append(" '" + user.getPassword() + "' ");
        sql.append(" ); ");

        return sql.toString();
    }

    public static User bind(Cursor cursor) {
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            User user = new User();
            user.setUser(cursor.getString(cursor.getColumnIndex(UserContract.USER)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(UserContract.PASSWORD)));

            return user;
        }
        return null;
    }
}
