package com.example.sebastinfelipe.manejosqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sebastinfelipe.manejosqlite.models.Planeta;

/**
 * Created by Sebasti�nFelipe on 07/05/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper
{
    static final String DB_NAME="sistemasolar.db";
    static int version=1;
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+PlanetaDao.TABLE_NAME+" " +
                        "( "+PlanetaDao.TABLE_PLANET_ID+" INTEGER AUTO_INCREMENT PRIMARY KEY," +
                        PlanetaDao.TABLE_PLANET_NAME+" VARCHAR(50), " +
                        PlanetaDao.TABLE_PLANET_GRAVITY+" FLOAT," +
                        PlanetaDao.TABLE_PLANET_POS+" INTEGER)");  //Código para crear
        ContentValues cV=new ContentValues();
        cV.put(PlanetaDao.TABLE_PLANET_NAME,"Tierra");
        cV.put(PlanetaDao.TABLE_PLANET_GRAVITY,9.8f);
        cV.put(PlanetaDao.TABLE_PLANET_POS,3);
        db.insert(PlanetaDao.TABLE_NAME,null,cV); //Insertar la Tierra

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
