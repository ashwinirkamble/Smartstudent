package com.example.ashwini.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

/**
 * Created by ashwini on 18/11/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String db_name="student.db";
    public static final String TABLE_NAME = "student";
    public static final String  NATIONALITY= "nat";
    public static final String AADHAR_NO = "aadhar";
    public static final String PASSPORT_NO= "passport";
    public static final String STUDENT_NAME = "name";
    public static final String EMAIL = "email";
    public static final String MOBILE_NO = "phone";
    private HashMap hp;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+TABLE_NAME+" (nat text,aadhar int primary key,passport int ,name text,email text,phone int )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS student");
    onCreate(db);
    }

    public boolean insertStudent(String nat,String aadhar, String passport,String name,String email,String phone)
    {
    SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("nat",nat);
        contentValues.put("aadhar", aadhar);
        contentValues.put("passport",passport);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);

        db.update("student", contentValues, "aadhar = ? ", new String[] { Integer.toString(Integer.parseInt(aadhar)) } );
        return true;
    }

}
