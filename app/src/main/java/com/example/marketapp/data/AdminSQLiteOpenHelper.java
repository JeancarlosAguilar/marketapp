package com.example.marketapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MARKETAPP";
    public static final String TABLE_NAME1 = "USER_DATA";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "FIRST_NAME";
    public static final String COL_5 = "LAST_NAME";
    public static final String COL_6 = "PHONE_NUMBER";
    public static final String COL_7 = "ADDRESS";

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT, FIRST_NAME TEXT, LAST_NAME TEXT, PHONE_NUMBER TEXT, ADDRESS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public void regUser(String email, String password, String firstname, String lastname, String phonenumber, String address) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, email);
        values.put(COL_3, password);
        values.put(COL_4, firstname);
        values.put(COL_5, lastname);
        values.put(COL_6, phonenumber);
        values.put(COL_7, address);
        db.insert(TABLE_NAME1, null, values);
    }

    public boolean checkRegUser(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columnas = {COL_1};
        String seleccion = COL_2 + "=?";
        String[] selecciongumentos = {email};
        Cursor cursor = db.query(TABLE_NAME1, columnas, seleccion, selecciongumentos, null, null, null);
        int cont = cursor.getCount();
        db.close();
        cursor.close();
        if (cont > 0)
            return true; // TRUE = EXISTE
        else
            return false; // FALSE = NO EXISTE
    }

    public boolean checkUserLogin(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        String[] columnas = {COL_1};
        String seleccion = COL_2 + "=?" + " and " + COL_3 + " =? ";
        String[] selecciongumentos = {email, password};
        Cursor cursor = db.query(TABLE_NAME1, columnas, seleccion, selecciongumentos, null, null, null);
        int cont = cursor.getCount();
        db.close();
        cursor.close();
        if (cont > 0)
            return true;
        else
            return false;
    }

}
