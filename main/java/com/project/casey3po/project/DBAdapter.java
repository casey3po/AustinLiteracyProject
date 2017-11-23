package com.project.casey3po.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Casey3po on 11/20/2017.
 */

public class DBAdapter {

    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "read.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table "+ Books.BookInfo.TABLE_NAME+" (_id integer primary key autoincrement, "
                    +Books.BookInfo.COLUMN_TITLE+" text not null, "
                    +Books.BookInfo.COLUMN_AUTHOR+" text not null);";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }

    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    //---insert a title into the database---
    public long insertTitle(String title, String author)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Books.BookInfo.COLUMN_TITLE, title);
        initialValues.put(Books.BookInfo.COLUMN_AUTHOR, author);
        return db.insert(Books.BookInfo.TABLE_NAME, null, initialValues);
    }

    //---retrieves all the titles---
    public Cursor getAllTitles()
    {
        return db.query(Books.BookInfo.TABLE_NAME, new String[] {
                        Books.BookInfo.COLUMN_TITLE,
                        Books.BookInfo.COLUMN_AUTHOR},
                null,
                null,
                null,
                null,
                null);
    }


}
