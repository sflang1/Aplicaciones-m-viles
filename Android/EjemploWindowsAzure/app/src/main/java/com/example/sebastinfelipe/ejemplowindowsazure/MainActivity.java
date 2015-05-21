package com.example.sebastinfelipe.ejemplowindowsazure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

import net.AzureClient;

import models.Ciudades;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, TableOperationCallback<Ciudades> {

    private EditText nombre, pais,poblacion;
    private Button aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText) findViewById(R.id.nomCiudad);
        pais=(EditText) findViewById(R.id.pais);
        poblacion=(EditText) findViewById(R.id.poblacion);
        aceptar=(Button) findViewById(R.id.aceptar);
        aceptar.setOnClickListener(this);
    }


    //region OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    //endregion

    @Override
    public void onClick(View v)
    {
        Ciudades c=new Ciudades();
        c.setNombre(nombre.getText().toString());
        c.setPais(pais.getText().toString());
        c.setPoblacion(Integer.parseInt(poblacion.getText().toString()));
        AzureClient.getAzureClient(getApplicationContext()).getTable(Ciudades.class).insert(c,this);
        //Se puede accesar mediante el nombre de la Tabla únicamente si equivale a la declarada en Windows Azure.
        //Se implementa la interfaz onCompleted para saber cuál fue la respuesta del servidor.
    }

    @Override
    public void onCompleted(Ciudades entity, Exception exception, ServiceFilterResponse response) {

    }
}
