package com.example.siteynetimitakip.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.siteynetimitakip.Entity.ApartmanSakini;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private final static String databaseName = "ApartmanSakinleriDB";
    private final static int databaseVersion = 1;
    private String ApartmanSakiniTABLE = "ApartmanSakinleri";
    private static DB dbInstance = null;

    public synchronized static DB getInstance(Context context)
    {
        if(dbInstance == null)
        {
            dbInstance = new DB(context.getApplicationContext());
        }
        return dbInstance;
    }

    public DB(Context context)
    {

        super(context,databaseName,null,databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + ApartmanSakiniTABLE + " ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " kiraciIsmi TEXT,"
                + " sahibiIsmi TEXT,"
                + " kiraciBorc TEXT,"
                + " sahibiBorc TEXT"
                + " )";

        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void addNewApartment(String kiraciIsmi, String sahibiIsmi, String kiraciBorc, String sahibiBorc)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("kiraciIsmi",kiraciIsmi);
        contentValues.put("sahibiIsmi",sahibiIsmi);
        contentValues.put("kiraciBorc",kiraciBorc);
        contentValues.put("sahibiBorc",sahibiBorc);

        sqLiteDatabase.insert(ApartmanSakiniTABLE,null,contentValues);

        sqLiteDatabase.close();

    }

    public ArrayList<ApartmanSakini> getAllAparment()
    {
        ArrayList<ApartmanSakini> apartmanSakiniArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(ApartmanSakiniTABLE,null,null,null,null,null,null);

        if(cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String kiraciIsmi = cursor.getString(cursor.getColumnIndexOrThrow("kiraciIsmi"));
                String sahibiIsmi = cursor.getString(cursor.getColumnIndexOrThrow("sahibiIsmi"));
                String kiraciBorc = cursor.getString(cursor.getColumnIndexOrThrow("kiraciBorc"));
                String sahibiBorc = cursor.getString(cursor.getColumnIndexOrThrow("sahibiBorc"));

                ApartmanSakini apartmanSakini = new ApartmanSakini(id,kiraciIsmi,sahibiIsmi,kiraciBorc,sahibiBorc);

                apartmanSakiniArrayList.add(apartmanSakini);



            }
            while(cursor.moveToNext());
        }


        return apartmanSakiniArrayList;
    }

    public void deleteApartment(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(ApartmanSakiniTABLE,"id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public void updateNote(int id, String kiraciIsmi, String sahibiIsmi, String kiraciBorc, String sahibiBorc)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("kiraciIsmi",kiraciIsmi);
        contentValues.put("sahibiIsmi",sahibiIsmi);
        contentValues.put("kiraciBorc",kiraciBorc);
        contentValues.put("sahibiBorc",sahibiBorc);

        sqLiteDatabase.update(ApartmanSakiniTABLE,contentValues,"id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public ApartmanSakini getApartmanSakini(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(ApartmanSakiniTABLE,null,"id= ? " ,new String[]{ String.valueOf(id) },null,null,null);

        ApartmanSakini apartmanSakini = null;

        if(cursor.moveToFirst())
        {
            do {
                int userId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String kiraciIsmi = cursor.getString(cursor.getColumnIndexOrThrow("kiraciIsmi"));
                String sahibiIsmi = cursor.getString(cursor.getColumnIndexOrThrow("sahibiIsmi"));
                String kiraciBorc = cursor.getString(cursor.getColumnIndexOrThrow("kiraciBorc"));
                String sahibiBorc = cursor.getString(cursor.getColumnIndexOrThrow("sahibiBorc"));

                apartmanSakini = new ApartmanSakini(userId,kiraciIsmi,sahibiIsmi,kiraciBorc,sahibiBorc);

            }
            while(cursor.moveToNext());
        }

        return apartmanSakini;
    }

}
