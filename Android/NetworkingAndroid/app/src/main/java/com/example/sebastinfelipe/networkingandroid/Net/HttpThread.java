package com.example.sebastinfelipe.networkingandroid.Net;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

/**
 * Created by SebastiánFelipe on 14/05/2015.
 */
public class HttpThread extends Thread
{
    private HttpThreadI HttpI;

    public interface HttpThreadI
    {
      public Handler getHandler();
    };
    public static final int TIPO_GET=0;
    public static final int TIPO_POST=1;
    private HttpConnection httpCon;
    private String data;
    private String url;
    private int tipo;

    /**
     *
     * @param u La url a mandar
     * @param d Datos a enviar
     * @param t Tipo de petición
     */
    public HttpThread(String u,String d,int t,HttpThreadI i)
    {
        url=u;
        data=d;
        tipo=t;
        HttpI=i;
        httpCon=new HttpConnection();

    }
    @Override
    public void run()
    {
        String rta=null;
        if(tipo==TIPO_GET)
        {

            try
            {
                rta=httpCon.requestStringbyGet(url,data);
            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                rta=httpCon.requestStringbyGet(url,data);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        Message msg=HttpI.getHandler().obtainMessage();
        msg.what=tipo;
        msg.obj=rta;
        HttpI.getHandler().sendMessage(msg);
    }
}
