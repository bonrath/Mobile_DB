package com.example.user_profile_db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    //declare database
    private static final String DATABASE_NAME="myUser.db";
    private static final int DATABASE_VERSION=1;
    //declare Table
    private static final String TABLE_NAME="User";
    private static final String Col1="UID";
    private static final String Col2="UName";
    private static final String Col3="UPassword";
    private static final String CreateTable_Statement="CREATE TABLE "+
            TABLE_NAME +"(" +
            Col1 +" TEXT not null,"+
            Col2 +" TEXT not null,"+
            Col3 +" TEXT not null)";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable_Statement );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        this.onCreate(db);
    }
    //Save, search,
    public void InsertData(String id, String name, String pass){
        SQLiteDatabase db= this.getWritableDatabase();

        db.execSQL("Insert into "+TABLE_NAME+
                " Values('"+ id +"', +'"+name+"', '"+pass+"')");
        db.close();
    }

    public Cursor SearchData(String uid){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor myCursor=db.rawQuery("Select * From User Where UID='"+uid+"'",null);
        myCursor.moveToFirst();
        return myCursor;

    }
    public void EditData(String id,String name, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+ " SET "+Col2+"='"+name+"',"+
                Col3+"='"+password+"' WHERE "+Col1+"='"+id+"'");
    }

    public void DeleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME +" WHERE UID='"+id+"'");
    }

    public Cursor GetAllUser(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor myCursor=db.rawQuery("Select * From User ",null);
        myCursor.moveToFirst();
        return myCursor;

    }







}
