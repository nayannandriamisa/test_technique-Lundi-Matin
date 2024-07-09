package com.example.lmbapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBManager extends SQLiteOpenHelper {

    private static final String dbname = "lundimatin.db";
    private static final int dbversion = 1;

    private static final String tableName = "clients";

    private static final String columnId = "id";
    private static final String columnName = "nomClient";
    private static final String columnFirstName = "prenomClient";
    private static final String columnNumber = "numeroClient";
    private static final String columnMail = "emailClient";
    private static final String columnAdress = "adresseClient";
    private static final String columnPostCode = "codePostalClient";
    private static final String columnCity = "villeClient";

    public DBManager(Context context) {
        super(context, dbname, null, dbversion, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName + "("
                + columnId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + columnName + " TEXT NOT NULL, "
                + columnFirstName + " TEXT NOT NULL, "
                + columnNumber + " INTEGER, "
                + columnMail + " TEXT NOT NULL, "
                + columnAdress + " TEXT NOT NULL, "
                + columnPostCode + " INTEGER, "
                + columnCity + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    Cursor getAllClients() {
        String query = "SELECT * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            db.rawQuery(query, null);
        }
        return cursor;
    }
}
