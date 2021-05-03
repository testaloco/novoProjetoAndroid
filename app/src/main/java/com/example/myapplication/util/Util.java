package com.example.myapplication.util;

import android.util.Log;

import com.example.myapplication.model.CovidBrasil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Util {

    public static final String URL_COVID = "https://covid19-brazil-api.now.sh/api/report/v1";

    public static String unmask(String s, Set<String> replaceSymbols) {

        for (String symbol : replaceSymbols)
            s = s.replaceAll("["+symbol+"]","");

        return s;
    }

    public static String mask(String format, String text){
        String maskedText="";
        int i =0;
        for (char m : format.toCharArray()) {
            if (m != '#') {
                maskedText += m;
                continue;
            }
            try {
                maskedText += text.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }
        return maskedText;
    }
    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    public static String streamToString(InputStream is){
        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String convertObjectJSON(Object p){
        Gson gson = new Gson();
        try {
            return gson.toJson(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void JSONtoEstadoCovid(String jsonString, ArrayList<CovidBrasil> listaCovidBrasil){
        try{
            CovidBrasil covidBrasil;
            JSONObject mainObj = new JSONObject(jsonString);
            JSONArray listaJson = mainObj.getJSONArray("data");

            for(int i = 0; i < listaJson.length(); i++){
                covidBrasil = new CovidBrasil();
                covidBrasil.setEstado(listaJson.getJSONObject(i).getString("uf"));
                listaCovidBrasil.add(covidBrasil);
            }
        }catch (Exception e){
            Log.e("ERROR","Error ",e);
        }
    }


}