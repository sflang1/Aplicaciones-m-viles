package com.example.sebastinfelipe.networkingandroid.Net;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SebastiánFelipe on 14/05/2015.
 */
public class HttpConnection
{
    HttpClient client;
    public HttpConnection()
    {
        client=new DefaultHttpClient();
    }

    /**
     * Esta función ejecuta una consulta con el método GET
     * @param url La dirección de la página a consultar
     * @param data Los datos a enviar en formato key=value&key=value...
     * @return El string que retorna el procesamiento
     * @throws IOException
     */
    public String requestStringbyGet(String url, String data) throws IOException {
        //Data se refiere a los datos que se pongan en el GET
        HttpGet request=new HttpGet(url+"?"+data);
        HttpResponse response=client.execute(request);
        return processResponse(response);
    }

    /**
     * Método para ejecutar un post a la dirección especificada por URL, y con los datos
     * que están en datapost.
     * @param url URL de la página
     * @param datapost Datos con el formato key=value&key=value....
     * @return Respuesta String de la solicitud
     */
    public String requestStringbyPost(String url,String datapost) throws IOException {
        //Par de llave valor que tiene el post
        List<NameValuePair> dataForm=new ArrayList<>();
        String [] formItems= datapost.split("&"),keyvalues;
        String key="",value="";
        for(int i=0;i<formItems.length;i++)
        {
            keyvalues=formItems[i].split("=");
            key=keyvalues[0];
            value=keyvalues[1];
            BasicNameValuePair vP=new BasicNameValuePair(key,value);  //Formar los pares de valores
            dataForm.add(vP);
        }
        UrlEncodedFormEntity form=new UrlEncodedFormEntity(dataForm);
        HttpPost request=new HttpPost(url);
        request.setEntity(form);
        HttpResponse response=client.execute(request);
        return processResponse(response);
    }
    public String processResponse(HttpResponse response) throws IOException {
        //Procesar la respuesta
        String rta= EntityUtils.toString(response.getEntity());
        return rta;
    }
}
