package com.example.sebastinfelipe.networkingandroid;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sebastinfelipe.networkingandroid.Net.HttpAsyncTask;
import com.example.sebastinfelipe.networkingandroid.Net.HttpThread;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity implements  View.OnClickListener, HttpAsyncTask.HttpAsyncTaskI {

    public final static String urlBusqueda="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22popayan%2Cco%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
    TextView temperatura,humedad,presion,pronostico;
    Button refrescar;


    private void processWeather(String obj)
    {
        try
        {
            JSONObject objeto=new JSONObject(obj);
            JSONObject q=objeto.getJSONObject("query");
            JSONObject r=q.getJSONObject("results");
            JSONObject ch=r.getJSONObject("channel");
            JSONObject a=ch.getJSONObject("atmosphere");
            String h=a.getString("humidity");
            String p=a.getString("pressure");
            JSONObject item=ch.getJSONObject("item");
            JSONObject cond=item.getJSONObject("condition");
            String temp=cond.getString("temp");
            String pron=cond.getString("text");
            Log.i("appHttp",temp+" "+h+" "+p+" "+pron);
            temperatura.setText(temp);
            pronostico.setText(pron);
            humedad.setText(h);
            presion.setText(p);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //HttpThread thread=new HttpThread(urlBusqueda,"",0,this);  No se hace con Threads sino con Async Tasks
        //thread.start();
        HttpAsyncTask httptask=new HttpAsyncTask(this,urlBusqueda,HttpAsyncTask.GET);
        httptask.execute();
        temperatura= (TextView) findViewById(R.id.temperatura);
        humedad= (TextView) findViewById(R.id.humedad);
        presion= (TextView) findViewById(R.id.presion);
        pronostico= (TextView) findViewById(R.id.pronostico);
        refrescar=(Button) findViewById(R.id.refrescar);
        refrescar.setOnClickListener(this);
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
    public void onClick(View v) {

    }

    @Override
    public void setResult(String rta)
    {
        Log.i("appHttp","Se recibe una respuesta");
        processWeather(rta);
    }
}
