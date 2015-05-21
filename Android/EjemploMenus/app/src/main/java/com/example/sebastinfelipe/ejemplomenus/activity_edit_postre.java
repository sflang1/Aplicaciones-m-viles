package com.example.sebastinfelipe.ejemplomenus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class activity_edit_postre extends ActionBarActivity implements View.OnClickListener {

    private Button editar;
    private EditText nomaeditar;
    private int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)  //Puede que no se pasen datos.
        {
            posicion=extras.getInt("pos");
        }
        setContentView(R.layout.activity_add_postre);
        nomaeditar=(EditText) findViewById(R.id.nuevopostre);
        editar=(Button) findViewById(R.id.aceptar);
        editar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_edit_postre, menu);
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
        String nuevonom=nomaeditar.getText().toString();
        MainActivity.datalist.set(posicion,nuevonom);
        finish();
    }
}
