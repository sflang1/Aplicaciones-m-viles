package com.example.sebastinfelipe.cambioconfiguracion.util;

/**
 * Created by SebastiánFelipe on 17/04/2015.
 */
public class AppUtil //Colocar variables globales
{
    private static String user="";
    private static String pass="";

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        AppUtil.user = user;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        AppUtil.pass = pass;
    }
}
