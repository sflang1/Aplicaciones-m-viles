package com.example.sebastinfelipe.cambioconfiguracion;

import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.sebastinfelipe.cambioconfiguracion.util.AppUtil;


public class MainActivity extends ActionBarActivity {

    private EditText username;
    private EditText password;
    private final static String KEY_USERNAME="txt_username";
    private final static String KEY_PASSWORD="txt_password";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password=(EditText) findViewById(R.id.password);
        username=(EditText) findViewById(R.id.username);
        /*if(savedInstanceState!=null)   //Ver si no hay instancia guardada
        {
            password.setText(savedInstanceState.getString(KEY_PASSWORD));
            username.setText(savedInstanceState.getString(KEY_USERNAME));
        }*/
        username.setText(AppUtil.getUser());
        password.setText(AppUtil.getPass());
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        /*String username= this.username.getText().toString();
        String password= this.password.getText().toString();
        outState.putString(KEY_USERNAME,username);
        outState.putString(KEY_PASSWORD,password);
        Log.i("aplicacion","Valores puestos en el bundle: "+username+" "+password);
        super.onSaveInstanceState(outState);*/
    }

    @Override
    protected void onDestroy() {
        AppUtil.setUser(username.getText().toString());
        AppUtil.setPass(username.getText().toString());
        super.onDestroy();
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
