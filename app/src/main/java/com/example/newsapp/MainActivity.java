package com.example.newsapp;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FetchArticles F = new FetchArticles("Fetch data");
        F.start();
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //FetchArticlesMethod();
    }

    void FetchArticlesMethod() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key = "c922f99970f1465183e05d64ed0ca123";

            Log.d("FETCH ARTICLES Starting GET","Starting GET");


            URL url = new URL("http://newsapi.org/v2/top-headlines?language=en&apiKey=c922f99970f1465183e05d64ed0ca123");

            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setDoOutput(true);
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


            /*URL url = new URL("http://newsapi.org/v2/top-headlines?language=en&apiKey=c922f99970f1465183e05d64ed0ca123");

            Log.d("FETCH ARTICLES Initialised URL variable","");


            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            Log.d("FETCH ARTICLES con variable initialised","");


            con.setRequestMethod("GET");


            con.setDoOutput(true);

            Log.d("Before connecting","");
            con.connect();

            Log.d("After connecting","");

            //String responseCode = String.valueOf(con.getResponseCode());

            //Log.d("Status code",responseCode);

            //Log.d("Status code",responseCode);

            InputStream ip = con.getInputStream();
            BufferedReader br1 =
                    new BufferedReader(new InputStreamReader(ip));


            Log.d("br1 created","br1 created");

            StringBuilder response = new StringBuilder();
            String responseSingle = null;
            while ((responseSingle = br1.readLine()) != null) {
                response.append(responseSingle);
            }
            String xx = response.toString();
            System.out.println(xx);
            Log.d("GET Successful",xx);

            */

            /*
            try {
                JSONObject obj = new JSONObject(xx);
                JSONObject articles = obj.getJSONObject("articles");
                String articles_STRING = obj.getString("articles");
                Log.d("ARTICLES", articles_STRING);
            } catch (JSONException e) {
                e.printStackTrace();
            }
             */
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}