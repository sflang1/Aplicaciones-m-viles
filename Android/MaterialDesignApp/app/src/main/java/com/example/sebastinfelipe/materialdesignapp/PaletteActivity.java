package com.example.sebastinfelipe.materialdesignapp;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class PaletteActivity extends ActionBarActivity {

    ImageView foto,vc,vo,vn,oc,oo,on;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        foto=(ImageView) findViewById(R.id.foto);
        vc=(ImageView) findViewById(R.id.VibranteClaro);
        vo=(ImageView) findViewById(R.id.VibranteOscuro);
        vn=(ImageView) findViewById(R.id.VibranteNormal);
        oc=(ImageView) findViewById(R.id.OpacoClaro);
        on=(ImageView) findViewById(R.id.OpacoNormal);
        oo=(ImageView) findViewById(R.id.OpacoOscuro);
        BitmapDrawable bd= (BitmapDrawable) foto.getDrawable();  //Obtener el bitmap del Drawable
        Palette p=Palette.from(bd.getBitmap()).generate();      //Saca los colores
        vc.setBackgroundColor(p.getLightVibrantColor(0));       //Asignarlos
        vo.setBackgroundColor(p.getDarkVibrantColor(0));
        vn.setBackgroundColor(p.getVibrantColor(0));
        oc.setBackgroundColor(p.getLightMutedColor(0));
        on.setBackgroundColor(p.getMutedColor(0));
        oo.setBackgroundColor(p.getDarkMutedColor(0));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_palette, menu);
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
