import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;



class fetchArticles
{
static void FetchArticles() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String key = "c922f99970f1465183e05d64ed0ca123";

    URL url = new URL("http://newsapi.org/v2/top-headlines?" + "language=en&" + "apiKey=" + key);

    HttpURLConnection con =
            (HttpURLConnection) url.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("language","en");
    con.setRequestProperty("apiKey", key);
    con.setInstanceFollowRedirects(false); 
    //con.setRequestProperty("Content-Type", "application/json");
    //con.setRequestProperty("Accept", "application/json");

    con.setDoOutput(true);

    OutputStream out = con.getOutputStream();

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

    try{
        JSONObject obj = new JSONObject(xx);
        JSONObject articles = obj.getJSONObject("articles");
        String articles_STRING = obj.getString("articles");
        System.out.println(articles_STRING);
    }
    catch (JSONException e)
    {
        e.printStackTrace();
    }
}


public static void main(String[] args)	throws IOException
{
	FetchArticles();
}
}