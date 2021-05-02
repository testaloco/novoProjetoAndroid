package com.example.myapplication.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.example.myapplication.util.Util;

import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionManager {
    /**
     * Executa GET de forma assincrona ao servidor
     */
    public static void executeGETAsync(Context context, String url) throws Exception{

        new AsyncTask<Object, Void, String>(){

            @Override
            protected String doInBackground(Object... params) {
                HttpURLConnection urlConnection = null;
                try {
                    urlConnection = (HttpURLConnection) new URL((String)params[0]).openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setRequestProperty("accept", "application/json");
                    urlConnection.connect();


                    urlConnection.getResponseCode();
                    /*da para desirilizar aqui*/
                    String response = Util.webToString(urlConnection.getInputStream());

                    return response ;
                } catch (Exception e) {
                    Log.e("Error", "Error ", e);
                    return null;
                } finally{
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            }
        }.execute(url);
    }
}
