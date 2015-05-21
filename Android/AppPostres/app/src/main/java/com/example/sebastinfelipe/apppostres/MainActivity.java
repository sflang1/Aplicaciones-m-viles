package com.example.sebastinfelipe.apppostres;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.sebastinfelipe.apppostres.adapters.PostreAdapter;
import com.example.sebastinfelipe.apppostres.models.Postre;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    PostreAdapter postreAdapter;
    List<Postre> data;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=new ArrayList<>();
        postreAdapter=new PostreAdapter(this,data);
        lista=(ListView) findViewById(R.id.list);
        lista.setAdapter(postreAdapter);
        loadPostres();
    }
    private void loadPostres()
    {
        data.clear();  //Limpiar todos los postres que hubiesen
        String [] array=getResources().getStringArray(R.array.postres);
        String cadena[];

        for (String anArray : array)
        {
            Log.i("app", anArray);
            cadena = anArray.split("#");
            Postre p = new Postre();
            p.setNombre(cadena[0]);
            p.setDescripcion(cadena[1]);
            p.setDuracion(cadena[2]);
            p.setPrecio(cadena[3]);
            data.add(p);
        }
        postreAdapter.notifyDataSetChanged();
    }

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
}
