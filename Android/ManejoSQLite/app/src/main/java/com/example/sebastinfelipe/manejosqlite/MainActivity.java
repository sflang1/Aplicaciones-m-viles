package com.example.sebastinfelipe.manejosqlite;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.sebastinfelipe.manejosqlite.adapters.PlanetAdapter;
import com.example.sebastinfelipe.manejosqlite.database.PlanetaDao;
import com.example.sebastinfelipe.manejosqlite.models.Planeta;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView lista;
    List<Planeta> data;
    PlanetAdapter padapter;
    PlanetaDao pdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdao=new PlanetaDao(this.getBaseContext());
        data=new ArrayList<>();
        data=pdao.getAll();
        lista=(ListView) findViewById(R.id.lista);
        padapter=new PlanetAdapter(this.getBaseContext(),data);
        lista.setAdapter(padapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        padapter.setData(pdao.getAll());
        padapter.notifyDataSetChanged();
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
        switch (id)
        {
            case R.id.action_add:
                Intent intent=new Intent(this,AddPlaneta.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
