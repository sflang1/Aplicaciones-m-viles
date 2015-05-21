package com.example.sebastinfelipe.manejosqlite.models;

/**
 * Created by SebastiánFelipe on 07/05/2015.
 */
public class Planeta
{
    private int idPlaneta;
    private String nombre;
    private float gravedad;
    private int pos;

    public int getIdPlaneta() {
        return idPlaneta;
    }

    public void setIdPlaneta(int idPlaneta) {
        this.idPlaneta = idPlaneta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
