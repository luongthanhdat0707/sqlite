package com.example.sqllife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "DB.sqlife", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Tacgia(" +
                "maso integer primary key, " +
                "ten text," +
                "diachi text," +
                "email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Tacgia");
        onCreate(sqLiteDatabase);
    }

    public int insertTacgia(TacGia tg) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maso", tg.getMaso());
        contentValues.put("ten", tg.getTen());
        contentValues.put("diachi", tg.getDiachi());
        contentValues.put("email", tg.getEmail());
        int result = (int) db.insert("Tacgia", null, contentValues);
        db.close();
        return result;
    }

    public ArrayList<TacGia> getAllTacgia() {
        ArrayList<TacGia> List = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select*from Tacgia", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            List.add(new TacGia(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return List;
    }

    public ArrayList<TacGia> Gettacgia (int maso) {
        ArrayList<TacGia> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Tacgia where maso=" + maso, null);
        if (cursor != null)
            cursor.moveToFirst();
        TacGia tg = new TacGia(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        list.add(tg);
        cursor.close();
        db.close();
        return list;
    }

}
