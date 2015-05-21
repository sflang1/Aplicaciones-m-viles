package com.example.sebastinfelipe.accesoadatos;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    static final String KEY_INFO="Nombre";
    TextView text;
    EditText nombre;
    Button aceptar;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView) findViewById(R.id.recuperado);
        nombre=(EditText) findViewById(R.id.nombre);
        aceptar=(Button) findViewById(R.id.enviar);
        aceptar.setOnClickListener(this);
        preferences=getPreferences(MODE_PRIVATE);
        text.setText("Se ha recuperado: "+preferences.getString(KEY_INFO,""));
    }

    //region Menu
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
        String n=nombre.getText().toString();
        preferences=getPreferences(MODE_PRIVATE);
        editor.putString(KEY_INFO,n);
        editor.commit();
    }
}
