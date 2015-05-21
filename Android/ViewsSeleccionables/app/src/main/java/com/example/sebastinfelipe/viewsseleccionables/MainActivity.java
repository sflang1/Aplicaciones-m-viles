package com.example.sebastinfelipe.viewsseleccionables;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    String[] colores;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView) findViewById(R.id.list);
        lista.setOnItemClickListener(this);
        colores=getResources().getStringArray(R.array.colores);
        //adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,colores);
        adapter=new ArrayAdapter<String>(this,R.layout.template_background,colores);
        lista.setAdapter(adapter);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String msg=getResources().getString(R.string.msg);
        msg=msg+" "+colores[position];
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
