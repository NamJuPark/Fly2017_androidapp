package com.example.hojan.fly2017_androidapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by 박남주 on 2017-08-29.
 */

public class DbOpenHelper {
    private static final String DATABASE_NAME = "SHDB";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    public DbOpenHelper(Context context) {
        this.mCtx = context;
    }

    public void close() {
        mDB.close();
    }

    public void INSERT(String time , int point) {
        mDB.execSQL("insert into flytofit values ('" + time + "','" + point + "' , '10');");
    }

    public void UPDATE(String oldTime, String time, int point) {
        mDB.execSQL("Update flytofit set point = " + point + " where time = '" + oldTime + "';");
        mDB.execSQL("Update flytofit set time = " + time + " where time = '" + oldTime + "';");
        mDB.execSQL("Update flytofit set db = 10 where time = '" + oldTime + "';");
    }

    public void delete(int time) {
        mDB.execSQL("Delete from  where time = " + time);
    }

    public Cursor getAll() {
        return mDB.rawQuery("Select * FROM flytofit", null);
    }

    public Cursor getTime() {
        return mDB.rawQuery("Select time FROM flytofit", null);
    }

    public Cursor getPoint() {
        return mDB.rawQuery("Select point FROM flytofit", null);
    }
    public Cursor getdb() {
        return mDB.rawQuery("Select db FROM flytofit", null);
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    private class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "Create table if not exists flytofit ("
                    + "time text primary key,"
                    + "point integer,"
                    + "db integer "
                    + ");";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("Drop table if exists flytofit");
            onCreate(db);
        }
    }
}
