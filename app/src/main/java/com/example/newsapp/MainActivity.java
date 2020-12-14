package com.example.newsapp;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FetchArticles F = new FetchArticles("Fetch data");
        //F.start();
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        FetchArticlesRapidAPI();
        TextView t = (TextView)findViewById(R.id.HelloWorld);
        t.setText("");
        //t.setText("After FetchArticlesMethod");
    }


    void FetchArticlesRapidAPI() {
        String xx;
        try {
            TextView t = (TextView) findViewById(R.id.HelloWorld);
            //URL url = new URL("https://bing-news-search1.p.rapidapi.com/news/trendingtopics?textFormat=Raw&safeSearch=Off");
            URL url = new URL("https://bing-news-search1.p.rapidapi.com/news/search?q=undefined&freshness=Day&textFormat=Raw&safeSearch=Off");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("x-bingapis-sdk", "true");
            connection.setRequestProperty("x-rapidapi-key", "366f026061msh65fe4ea294cb47ep140196jsn494afcb749cb");
            connection.setRequestProperty("x-rapidapi-host", "bing-news-search1.p.rapidapi.com");
            connection.setRequestProperty("Accept-Language", "en-gb,en");
            connection.setRequestProperty("count", "10");
            connection.setRequestMethod("GET");
            try {
                //connection.setChunkedStreamingMode(0);
                String responseCode = String.valueOf(connection.getResponseCode());
                String responseMessage = connection.getResponseMessage();

                Log.d("FETCH Response Code", responseCode);
                Log.d("FETCH Response Msg", responseMessage);


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                StringBuilder response = new StringBuilder();
                String responseSingle = null;
                while ((responseSingle = in.readLine()) != null) {
                    response.append(responseSingle);
                    System.out.println(responseSingle);
                    System.out.println();
                }
                xx = response.toString();
                System.out.println(xx);
                t.setText(xx);
            } catch (IOException e) {
                BufferedReader err = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder ERROR = new StringBuilder();
                String ERROR_LINE = null;
                while ((ERROR_LINE = err.readLine()) != null) {
                    ERROR.append(ERROR_LINE);
                }
                String finalError = ERROR.toString();
                System.out.println(finalError);
                Log.d("FETCH ERROR", finalError);
                t.setText(finalError);
                Map<String, List<String>> URLHeaders = connection.getHeaderFields();
                for (String keyValue : URLHeaders.keySet()) {
                }
                connection.disconnect();
                return;
            } finally {
                connection.disconnect();
            }


            try {
                JSONObject obj = new JSONObject(xx);
                JSONArray articles = obj.getJSONArray("value");
                String articles_STRING = obj.getString("value");
                Log.d("ARTICLES", articles_STRING);
                ArrayList<String> articleHeadings = new ArrayList<String>();
                if (articles != null) {
                    /*int len = articles.length();
                    for (int i = 0; i < len; i++) {
                        articleHeadings.add(articles.getJSONObject(i).getString("name"));
                    }*/


                    //System.out.println(articleHeadings);
                    int L = articles.length() >= 10 ? 10 : articles.length();
                    TextView h;
                    switch (L)
                    {
                        case 10:
                            h = (TextView) findViewById(R.id.headline10);
                            h.setText(articles.getJSONObject(9).getString("name"));
                        case 9:
                            h = (TextView) findViewById(R.id.headline9);
                            h.setText(articles.getJSONObject(8).getString("name"));
                        case 8:
                            h = (TextView) findViewById(R.id.headline8);
                            h.setText(articles.getJSONObject(7).getString("name"));
                        case 7:
                            h = (TextView) findViewById(R.id.headline7);
                            h.setText(articles.getJSONObject(6).getString("name"));
                        case 6:
                            h = (TextView) findViewById(R.id.headline6);
                            h.setText(articles.getJSONObject(5).getString("name"));
                        case 5:
                            h = (TextView) findViewById(R.id.headline5);
                            h.setText(articles.getJSONObject(4).getString("name"));
                        case 4:
                            h = (TextView) findViewById(R.id.headline4);
                            h.setText(articles.getJSONObject(3).getString("name"));
                        case 3:
                            h = (TextView) findViewById(R.id.headline3);
                            h.setText(articles.getJSONObject(2).getString("name"));
                        case 2:
                            h = (TextView) findViewById(R.id.headline2);
                            h.setText(articles.getJSONObject(1).getString("name"));
                        case 1:
                            h = (TextView) findViewById(R.id.headline1);
                            h.setText(articles.getJSONObject(0).getString("name"));
                    }
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    void FetchArticlesNewsAPI() {
        String xx;
        try {
            TextView t = (TextView) findViewById(R.id.HelloWorld);
            //URL url = new URL("https://bing-news-search1.p.rapidapi.com/news/trendingtopics?textFormat=Raw&safeSearch=Off");
            URL url = new URL("https://newsapi.org/v2/top-headlines?language=en&apiKey=c922f99970f1465183e05d64ed0ca123");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
            connection.setInstanceFollowRedirects(false);
            try {
                //connection.setChunkedStreamingMode(0);
                String responseCode = String.valueOf(connection.getResponseCode());
                String responseMessage = connection.getResponseMessage();

                Log.d("FETCH Response Code", responseCode);
                Log.d("FETCH Response Msg", responseMessage);


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                StringBuilder response = new StringBuilder();
                String responseSingle = null;
                while ((responseSingle = in.readLine()) != null) {
                    response.append(responseSingle);
                    System.out.println(responseSingle);
                    System.out.println();
                }
                xx = response.toString();
                System.out.println(xx);
                t.setText(xx);
            } catch (IOException e) {
                BufferedReader err = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder ERROR = new StringBuilder();
                String ERROR_LINE = null;
                while ((ERROR_LINE = err.readLine()) != null) {
                    ERROR.append(ERROR_LINE);
                }
                String finalError = ERROR.toString();
                System.out.println(finalError);
                Log.d("FETCH ERROR", finalError);
                t.setText(finalError);
                Map<String, List<String>> URLHeaders = connection.getHeaderFields();
                for (String keyValue : URLHeaders.keySet()) {
                }
                connection.disconnect();
                return;
            } finally {
                connection.disconnect();
            }


            try {
                JSONObject obj = new JSONObject(xx);
                JSONArray articles = obj.getJSONArray("articles");
                String articles_STRING = obj.getString("articles");
                Log.d("ARTICLES", articles_STRING);
                ArrayList<String> articleHeadings = new ArrayList<String>();
                if (articles != null) {
                    /*int len = articles.length();
                    for (int i = 0; i < len; i++) {
                        articleHeadings.add(articles.getJSONObject(i).getString("name"));
                    }*/


                    //System.out.println(articleHeadings);
                    int L = articles.length() >= 10 ? 10 : articles.length();
                    TextView h;
                    switch (L)
                    {
                        case 10:
                            h = (TextView) findViewById(R.id.headline10);
                            h.setText(articles.getJSONObject(9).getString("title"));
                        case 9:
                            h = (TextView) findViewById(R.id.headline9);
                            h.setText(articles.getJSONObject(8).getString("title"));
                        case 8:
                            h = (TextView) findViewById(R.id.headline8);
                            h.setText(articles.getJSONObject(7).getString("title"));
                        case 7:
                            h = (TextView) findViewById(R.id.headline7);
                            h.setText(articles.getJSONObject(6).getString("title"));
                        case 6:
                            h = (TextView) findViewById(R.id.headline6);
                            h.setText(articles.getJSONObject(5).getString("title"));
                        case 5:
                            h = (TextView) findViewById(R.id.headline5);
                            h.setText(articles.getJSONObject(4).getString("title"));
                        case 4:
                            h = (TextView) findViewById(R.id.headline4);
                            h.setText(articles.getJSONObject(3).getString("title"));
                        case 3:
                            h = (TextView) findViewById(R.id.headline3);
                            h.setText(articles.getJSONObject(2).getString("title"));
                        case 2:
                            h = (TextView) findViewById(R.id.headline2);
                            h.setText(articles.getJSONObject(1).getString("title"));
                        case 1:
                            h = (TextView) findViewById(R.id.headline1);
                            h.setText(articles.getJSONObject(0).getString("title"));
                    }
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    void FetchArticlesMethod() {
        try {
            TextView t = (TextView)findViewById(R.id.HelloWorld);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key = "c922f99970f1465183e05d64ed0ca123";
            //String url = "https://newsapi.org/v2/top-headlines?language=en&apiKey=c922f99970f1465183e05d64ed0ca123";
            URL url = new URL("https://newsapi.org/v2/top-headlines?language=en&apiKey=c922f99970f1465183e05d64ed0ca123");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
            connection.setInstanceFollowRedirects(false);
            try{
                connection.setChunkedStreamingMode(0);
                String responseCode = String.valueOf(connection.getResponseCode());
                String responseMessage = connection.getResponseMessage();

                Log.d("FETCH Response Code",responseCode);
                Log.d("FETCH Response Msg",responseMessage);


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                StringBuilder response = new StringBuilder();
                String responseSingle = null;
                while ((responseSingle = in.readLine()) != null)
                {
                    response.append(responseSingle);
                    //System.out.println(responseSingle);
                    //System.out.println();
                }
                String xx = response.toString();
                System.out.println(xx);
                t.setText(xx);
            }
            catch(IOException e){
                BufferedReader err = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder ERROR = new StringBuilder();
                String ERROR_LINE = null;
                while ((ERROR_LINE = err.readLine()) != null)
                {
                    ERROR.append(ERROR_LINE);
                }
                String finalError = ERROR.toString();
                System.out.println(finalError);
                Log.d("FETCH ERROR",finalError);
                t.setText(finalError);
                Map<String, List<String>> URLHeaders = connection.getHeaderFields();
                for(String keyValue : URLHeaders.keySet()){
                }
            }
            finally{
                connection.disconnect();
            }






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