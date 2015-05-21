package com.example.sebastinfelipe.ejemplomenus;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements DialogInterface.OnClickListener {
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private String[] data;
    private int posicion;
    public static List<String> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView) findViewById(R.id.lista);
        data=getResources().getStringArray(R.array.postres);
        datalist=new ArrayList<>();
        for(int i=0;i<data.length;i++)
        {
            datalist.add(data[i]);
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datalist);
        lista.setAdapter(adapter);
        registerForContextMenu(lista);
    }

    @Override
    protected void onRestart()
    {
        adapter.notifyDataSetChanged();
        super.onRestart();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        getMenuInflater().inflate(R.menu.menu_contextual_list,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String cadena="Seleccionaste: ";
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        posicion=info.position;
        switch (item.getItemId())
        {
            case R.id.action_edit:
                Intent intent=new Intent(this,activity_edit_postre.class);
                intent.putExtra("pos",posicion);
                startActivity(intent);
                Toast.makeText(this,cadena+"editar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(this,cadena+"eliminar",Toast.LENGTH_SHORT).show();
                showAlertDelete();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showAlertDelete()
    {
        AlertDialog alert=new AlertDialog.Builder(this).setTitle("Eliminar postre").setMessage("¿Estás seguro de eliminar este postre?").setNegativeButton("Cancelar",this).setPositiveButton("Aceptar",this).create();
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String cadena="Seleccionaste: ";
        switch (item.getItemId())
        {
            case R.id.action_add:
                Toast.makeText(this,cadena+"agregar",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,AddPostre.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                Toast.makeText(this,cadena+"acerca de",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.action_info:
                Toast.makeText(this,cadena+"información",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_others:
                Toast.makeText(this,cadena+"más",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        if(which==DialogInterface.BUTTON_POSITIVE)
        {
            datalist.remove(posicion);
            adapter.notifyDataSetChanged();
        }
    }
}
