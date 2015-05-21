package com.example.sebastinfelipe.manejosqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sebastinfelipe.manejosqlite.models.Planeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SebastiánFelipe on 07/05/2015.
 */
public class PlanetaDao
{
    public static final String TABLE_NAME="Planeta";
    public static final String TABLE_PLANET_ID="idPlaneta";
    public static final String TABLE_PLANET_NAME="nomPlaneta";
    public static final String TABLE_PLANET_GRAVITY="gravPlaneta";
    public static final String TABLE_PLANET_POS="posPlaneta";

    SQLiteDatabase db;
    public PlanetaDao(Context context)
    {
        DataBaseHelper helper=new DataBaseHelper(context);
        db=helper.getWritableDatabase();
    }
    public void insertRow(Planeta planeta)
    {
        ContentValues cV=new ContentValues();
        cV.put(TABLE_PLANET_NAME,planeta.getNombre());
        cV.put(TABLE_PLANET_POS,planeta.getPos());
        cV.put(TABLE_PLANET_GRAVITY,planeta.getGravedad());
        planeta.setIdPlaneta((int) db.insert(TABLE_NAME, null, cV));

    }
    public void updateRow(Planeta planeta)
    {
        ContentValues cV=new ContentValues();
        cV.put(TABLE_PLANET_NAME,planeta.getNombre());
        cV.put(TABLE_PLANET_POS,planeta.getPos());
        cV.put(TABLE_PLANET_GRAVITY,planeta.getGravedad());
        db.update(TABLE_NAME, null, TABLE_PLANET_ID + "=" + planeta.getIdPlaneta(), null);
    }
    public void deleteRow(Planeta planeta)
    {
        db.delete(TABLE_NAME, TABLE_PLANET_ID + "=" + planeta.getIdPlaneta(), null);
    }
    public List<Planeta> getAll()
    {
        String sql="SELECT * FROM "+TABLE_NAME;
        List<Planeta> planetas=new ArrayList<>();
        Cursor c=db.rawQuery(sql,null);
        if(c.getCount()>0)
        {
            while(c.moveToNext())
            {
                Planeta p=new Planeta();
                p.setIdPlaneta(c.getInt(0));
                p.setNombre(c.getString(1));
                p.setGravedad(c.getFloat(2));
                p.setPos(c.getInt(3));
                planetas.add(p);
            }
        }
        return planetas;
    }
    public List<Planeta> getPlanetbyFragmentName(String busqueda)
    {
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE "+TABLE_PLANET_NAME+" LIKE '%"+busqueda+"%'";
        List<Planeta> planetas=new ArrayList<>();
        Cursor c=db.rawQuery(sql,null);
        if(c.getCount()>0)
        {
            while(c.moveToNext())
            {
                Planeta p=new Planeta();
                p.setIdPlaneta(c.getInt(0));
                p.setNombre(c.getString(1));
                p.setGravedad(c.getFloat(2));
                p.setPos(c.getInt(3));
                planetas.add(p);
            }
        }
        return planetas;
    }
    public Planeta getObject(int id)
    {
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE "+TABLE_PLANET_ID+"="+id;
        Planeta p=null;
        Cursor c=db.rawQuery(sql,null);
        if(c.getCount()>0)
        {
            //Hay resultado en el cursor
            c.moveToNext();
            p=new Planeta();
            p.setIdPlaneta(id);
            p.setNombre(c.getString(1));
            p.setGravedad(c.getFloat(2));
            p.setPos(c.getInt(3));
        }
        return p;
    }
}
