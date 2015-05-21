package net;

import android.content.Context;
import android.util.Log;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import java.net.MalformedURLException;

/**
 * Created by SebastiánFelipe on 06/05/2015.
 */
public class AzureClient
{
    private static MobileServiceClient client;
    public static MobileServiceClient getAzureClient(Context context)
    {
        if(client==null)
        {
            try
            {
                client=new MobileServiceClient("https://test-mobile-dar.azure-mobile-net/","e4892da7-894f-4d40-8910-951d660efd2d",context);   //Recibe la URL del Servicio y el Token.
            }
            catch (MalformedURLException e)
            {
                Log.i("appAzure", "URL mal formada. No se pudo acceder");
                e.printStackTrace();
            }
        }
        return client;
    }
}
