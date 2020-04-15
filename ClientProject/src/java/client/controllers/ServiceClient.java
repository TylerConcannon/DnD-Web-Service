package client.controllers;

import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.*;
import client.models.*;
import java.io.InputStream;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;




class ServiceClient {
    private static final String diceRollerUrl = "http://localhost:8084/ServiceProject/diceRoller";
    private static final String contentUrl = "http://localhost:8084/ServiceProject/content";

    private static final String deployUrl = "http://localhost:8080/ServiceProject/diceRoller";
    
    public static void main(String[ ] args) {
        new ServiceClient().sendRequest();
    }

    private void sendRequest() {

           // HttpPost post = new HttpPost(url);

            
//            conn = getConnection(url, "POST");
//            conn.setRequestProperty("accept", "text/plain");
//
//            conn.connect();
//            getResponse(conn);
        
            sendContentRequest();
         //   sendDiceRequest();
    }
    
    private void sendContentRequest()
    {
            try {
            HttpClient client = HttpClientBuilder.create().build();

             HttpGet get = new HttpGet(contentUrl + "?rarity=Rare&type=Armor");
            // StringEntity entity = new StringEntity(payload.toJson(roll));
           //  get.setEntity(entity);
           //  get.setHeader("Content-type", "application/json");

             ClassicHttpResponse res = (ClassicHttpResponse) client.execute(get);
             //HttpResponse response = client.execute(get);
             HttpEntity ent = res.getEntity();
             String str = EntityUtils.toString(ent, "UTF-8");

             Gson gson = new Gson();
             Loot loot = gson.fromJson(str, Loot.class);
             //DiceRoll serviceRoll = gson.fromJson(str, DiceRoll.class);

                 
                 
                 int i = 0;
            }
            catch (Exception e)
            {
                
            }
    }
    
    private void sendDiceRequest() {
            HttpClient client = HttpClientBuilder.create().build();
            
            Gson payload = new Gson();
            DiceRoll roll = new DiceRoll();
            
            ArrayList<Integer> roll1 = new ArrayList<>();
            roll1.add(6);
            roll1.add(4);
            
            ArrayList<Integer> roll2 = new ArrayList<>();
            roll2.add(8);
            roll2.add(4);
            
            ArrayList<List<Integer>> rolls = new ArrayList<>(); 
            rolls.add(roll1);
            rolls.add(roll2);
            
            roll.setRolls(rolls);

            try {
                 HttpGet get = new HttpGet(diceRollerUrl);
                 StringEntity entity = new StringEntity(payload.toJson(roll));
                 get.setEntity(entity);
                 get.setHeader("Content-type", "application/json");

                 ClassicHttpResponse res = (ClassicHttpResponse) client.execute(get);
                 HttpResponse response = client.execute(get);
                 HttpEntity ent = res.getEntity();
                 String str = EntityUtils.toString(ent, "UTF-8");
                 
                 Gson gson = new Gson();
                 DiceRoll serviceRoll = gson.fromJson(str, DiceRoll.class);
                 
                 
                 
                 int i = 0;
            }
            catch (Exception e)
            {
                
            }
    }

    private HttpURLConnection getConnection(String url_string, String verb) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(verb);
            conn.setDoInput(true);
            conn.setDoOutput(true);
        }
        catch(MalformedURLException e) { System.err.println(e); }
        catch(IOException e) { System.err.println(e); }
        return conn;
    }
    private void getResponse(HttpURLConnection conn) {
        try {
            String xml = "";
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String next = null;
            while ((next = reader.readLine()) != null)
                xml += next;
            System.out.println(xml);
        }
        catch(IOException e) { System.err.println(e); }
    }
}
