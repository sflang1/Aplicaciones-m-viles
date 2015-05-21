package com.example.sebastinfelipe.ejemplofragments;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


public class DrawerActivity extends ActionBarActivity implements ListColorFragment.ListColorI, DrawerLayout.DrawerListener {

    private FrameLayout contenido;
    private DrawerLayout drawer;
    ListColorFragment listF;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        setColorFragment(0);  //Carga del primer color.
        listF=(ListColorFragment) getSupportFragmentManager().findFragmentById(R.id.containerBarra);
        listF.init(this);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawer,R.string.drawer_open,R.string.drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //Especificar el botón Home y que esté habilitado.
        drawer.setDrawerListener(this);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();   //Muestra el toggle

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    private void setColorFragment(int color)
    {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ColorFragment fragment=new ColorFragment();
        fragment.init(color);
        ft.replace(R.id.containerContenido,fragment);
        ft.commit();
    }

    //region OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion
    @Override
    public void changeColor(int color)
    {
        setColorFragment(color);
        drawer.closeDrawers();
    }

    //region Drawer Listener
    @Override
    public void onDrawerSlide(View view, float v) {
        toggle.onDrawerSlide(view,v);
    }

    @Override
    public void onDrawerOpened(View view) {
        toggle.onDrawerOpened(view);
    }

    @Override
    public void onDrawerClosed(View view) {
        toggle.onDrawerClosed(view);
    }

    @Override
    public void onDrawerStateChanged(int i) {
        toggle.onDrawerStateChanged(i);
    }
    //endregion
}
