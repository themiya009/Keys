package com.erendev.keys;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databasename = "Users.db";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Users.db", null, 1);
    }

    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE allusers(name TEXT, username TEXT PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS allusers");
    }

    public Boolean insertData(String name, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("name", name);
        contentValues.put("username", username);
        contentValues.put("password", password);

        long result = db.insert("allusers", null, contentValues);

        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM allusers where username = ?", new String[]{username});

        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkPassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM allusers where username = ? and password = ?", new String[]{username,password});

        if(cursor.getCount() > 0 ){
            return true;
        } else {
            return false;
        }
    }
}
