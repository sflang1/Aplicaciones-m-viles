package com.example.sebastinfelipe.ejemplofragments;


import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    ColorFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        fragment=new ColorFragment();
        fragment.init(ColorFragment.RED);
        ColorFragment fragment2=new ColorFragment();
        fragment2.init(ColorFragment.BLUE);
        //Agregar la lógica de cambios de Fragments
        if(getResources().getBoolean(R.bool.portrait))
        {
            ft.replace(R.id.container,fragment);
        }
        else
        {
            ft.replace(R.id.container1,fragment);
            ft.replace(R.id.container2,fragment2);
        }
        ft.commit();
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
