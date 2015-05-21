package com.example.sebastinfelipe.networkingandroid.Net;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by SebastiánFelipe on 15/05/2015.
 */
public class HttpAsyncTask extends AsyncTask<String,Integer,String>
{
    public static final int GET=0;
    public static final int POST=1;
    public interface HttpAsyncTaskI
    {
        public void setResult(String rta);
    }
    String url;
    int tipo;
    HttpConnection conn;
    HttpAsyncTaskI httpI;
    public  HttpAsyncTask(HttpAsyncTaskI i,String url,int t)
    {
        this.url=url;
        tipo=t;
        httpI=i;
        conn=new HttpConnection();
    }
    @Override
    protected String doInBackground(String... params)  //Los tres puntos indica que se pueden poner múltiples parámetros tipo String
    {
        String rta=null;
        try
        {
            if(tipo==POST)
            {
                rta=conn.requestStringbyPost(url,"");
            }
            else
            {
                rta=conn.requestStringbyGet(url,"");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return rta;
    }

    @Override
    protected void onPostExecute(String s)
    {
        httpI.setResult(s);
    }
}
