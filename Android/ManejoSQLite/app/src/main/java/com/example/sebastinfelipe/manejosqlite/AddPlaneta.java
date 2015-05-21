package com.example.sebastinfelipe.manejosqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sebastinfelipe.manejosqlite.database.PlanetaDao;
import com.example.sebastinfelipe.manejosqlite.models.Planeta;


public class AddPlaneta extends ActionBarActivity implements View.OnClickListener {

    EditText nombre,gravedad,pos;
    Button b;
    PlanetaDao pdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_planeta);
        nombre= (EditText) findViewById(R.id.nombre);
        gravedad= (EditText) findViewById(R.id.gravedad);
        pos= (EditText) findViewById(R.id.posicion);
        b=(Button) findViewById(R.id.aceptar);
        b.setOnClickListener(this);
        pdao=new PlanetaDao(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_planeta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        Planeta p=new Planeta();
        p.setGravedad(Float.parseFloat(gravedad.getText().toString()));
        p.setPos(Integer.parseInt(pos.getText().toString()));
        p.setNombre(nombre.getText().toString());
        pdao.insertRow(p);
        finish();
    }
}
