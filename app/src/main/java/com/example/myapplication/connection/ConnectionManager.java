package com.example.myapplication.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.example.myapplication.model.CovidBrasil;
import com.example.myapplication.util.Util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ConnectionManager {
    private ArrayList<CovidBrasil> listaCovidBrasil;

    public ConnectionManager(ArrayList<CovidBrasil> listaCovidBrasil){
        this.listaCovidBrasil = listaCovidBrasil;
    }

    public void recuperarValoresEstados(){
        new RecuperarEstadosCovid().execute();
    }
    private class RecuperarEstadosCovid extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(Util.URL_COVID);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                String result = Util.webToString(urlConnection.getInputStream());

                return result;
            } catch (Exception e) {
                Log.e("Error", "Error ", e);
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Util.JSONtoEstadoCovid(s,listaCovidBrasil);
            if(listaCovidBrasil == null || listaCovidBrasil.isEmpty()){
                Log.e("ERROR","Deu ao deserializar");
            }
        }
    }

}
