package com.example.newsapp;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchArticles implements Runnable {
    private Thread t;
    private String threadName;

    FetchArticles(String name){
        threadName = name;
        Log.d("FetchArticles Constructor","Constructor of fetchArticles initiated");
    }

    public void run()
    {
        try {
            /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key = "c922f99970f1465183e05d64ed0ca123";

            Log.d("API fetch start","Starting fetching data from API");
            URL url = new URL("http://newsapi.org/v2/top-headlines?" + "language=en?" + "apiKey=" + key);
            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            //con.setRequestMethod("GET");
            //con.setRequestProperty("apiKey", key);
            //con.setInstanceFollowRedirects(false);
            //con.setRequestProperty("Content-Type", "application/json");
            //con.setRequestProperty("Accept", "application/json")

            con.setDoOutput(true);
            con.setDoInput(true);

            con.connect();

//            OutputStream out = con.getOutputStream();

            InputStream ip = con.getInputStream();
            BufferedReader br1 =
                    new BufferedReader(new InputStreamReader(ip));

            StringBuilder response = new StringBuilder();
            String responseSingle = null;
            while ((responseSingle = br1.readLine()) != null) {
                response.append(responseSingle);
            }
            String xx = response.toString();
            System.out.println(xx);*/


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key = "c922f99970f1465183e05d64ed0ca123";

            Log.d("FETCH ARTICLES Starting GET","Starting GET");


            URL url = new URL("http://newsapi.org/v2/top-headlines?language=en&apiKey=c922f99970f1465183e05d64ed0ca123");

            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.connect();

            String responseCode = String.valueOf(con.getResponseCode());
            String responseMessage = con.getResponseMessage();

            Log.d("FETCH ARTICLES RESPONSE CODE",responseCode);
            Log.d("FETCH ARTICLES RESPONSE MESSAGE",responseMessage);
            InputStream ip = con.getInputStream();
            BufferedReader br1 =
                    new BufferedReader(new InputStreamReader(ip));

            StringBuilder response = new StringBuilder();
            String responseSingle = null;
            while ((responseSingle = br1.readLine()) != null)
            {
                response.append(responseSingle);
                //System.out.println(responseSingle);
                //System.out.println();
            }
            String xx = response.toString();
            System.out.println(xx);

            Log.d("FETCH ARTICLES RETURNED CONTENT",xx);




            try {
                JSONObject obj = new JSONObject(xx);
                JSONObject articles = obj.getJSONObject("articles");
                String articles_STRING = obj.getString("articles");
                Log.d("ARTICLES", articles_STRING);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
