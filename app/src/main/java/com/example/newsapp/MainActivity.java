package com.example.newsapp;

import android.os.Bundle;
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
        setContentView(R.layout.activity_main);
        FetchArticles();
    }

    /*void FetchArticles() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key = "c922f99970f1465183e05d64ed0ca123";

            URL url = new URL("https://newsapi.org/v2/top-headlines?" + "language=en?" + "apiKey=" + key);
            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("apiKey", key);
            con.setInstanceFollowRedirects(false);
            //con.setRequestProperty("Content-Type", "application/json");
            //con.setRequestProperty("Accept", "application/json")

            OutputStream out = con.getOutputStream();

            InputStream ip = con.getInputStream();
            BufferedReader br1 =
                    new BufferedReader(new InputStreamReader(ip));

            StringBuilder response = new StringBuilder();
            String responseSingle = null;
            while ((responseSingle = br1.readLine()) != null) {
                response.append(responseSingle);
            }
            String xx = response.toString();
            System.out.println(xx);

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
    }*/
}


class FetchArticles implements Runnable {
    private Thread t;
    private String threadName;

    FetchArticles(String name){
        threadName = name;
        Log.d("Constructor of fetchArticles initiated");
    }

    
}
