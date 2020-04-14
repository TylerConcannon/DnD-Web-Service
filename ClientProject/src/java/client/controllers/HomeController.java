/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controllers;

/**
 *
 * @author larry
 */
import client.models.DiceRoll;
import client.models.Message;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private static final String url = "http://localhost:8084/ServiceProject/diceRoller";

    @RequestMapping("/index")
    public ModelAndView index()
    {
//        sendPost();
//        sendRoller();
//        sendContent();
//        sendEncounter();
//        sendCharacter();
//        sendAbout();
        return new ModelAndView("index");
    }
    
    @RequestMapping("/roll")
    public ModelAndView roll()
    {

        return new ModelAndView("roll");
    }
    
    @RequestMapping("/randomContent")
    public ModelAndView randomContent()
    {

        return new ModelAndView("randomContent");
    }
    
    @RequestMapping("/randomEncounter")
    public ModelAndView randomEncounter()
    {

        return new ModelAndView("randomEncounter");
    }
    
    @RequestMapping("/randomCharacter")
    public ModelAndView randomCharacter()
    {

        return new ModelAndView("randomCharacter");
    }
    
    @RequestMapping("/about")
    public ModelAndView about()
    {

        return new ModelAndView("about");
    }
    

    @RequestMapping("/welcome")
    public ModelAndView welcome()
    {
        String message = "<br><div style='text-align:center;'>"
                            + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }
    
    @RequestMapping(value="/getRoll")
    private String sendRoller(@RequestBody Object dices)
    {
//        HttpClient client = HttpClientBuilder.create().build();
//
//        HttpGet get = new HttpGet(url + "?rolls=test");
//        get.addHeader("accept", "text/plain");
//        try {
//            HttpResponse response = client.execute(get);
//        } catch (IOException ex) {
//            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
        return dices.toString();
//        DiceRoll diceRolls = new DiceRoll();
//        
//      
//        ArrayList<Integer> roll1 = new ArrayList<>();
//        roll1.add(6);
//        roll1.add(4);
//
//        ArrayList<Integer> roll2 = new ArrayList<>();
//        roll2.add(8);
//        roll2.add(4);
//
//        ArrayList<List<Integer>> rolls = new ArrayList<>(); 
//        rolls.add(roll1);
//        rolls.add(roll2);
//        
//        diceRolls.setRolls(rolls);
//        
//        ModelAndView mv = new ModelAndView("roll", "model", diceRolls);
        //return mv;
    }
    
       @RequestMapping("/getRandomContent")
    private void sendContent()
    {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet(url + "?randomContent=test");
        get.addHeader("accept", "text/plain");
        try {
            HttpResponse response = client.execute(get);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
           @RequestMapping("/getRandomEncounter")
    private void sendEncounter()
    {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet(url + "?randomEncounter=test");
        get.addHeader("accept", "text/plain");
        try {
            HttpResponse response = client.execute(get);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
           @RequestMapping("/getRandomCharacter")
    private void sendCharacter()
    {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet(url + "?randomCharacter=test");
        get.addHeader("accept", "text/plain");
        try {
            HttpResponse response = client.execute(get);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
             @RequestMapping("/getAbout")
    private void sendAbout()
    {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet(url + "?randomCharacter=test");
        get.addHeader("accept", "text/plain");
        try {
            HttpResponse response = client.execute(get);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendPost() {
    try {
        HttpURLConnection conn = null;
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

        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(payload.toJson(rolls));
        post.setEntity(entity);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = client.execute(post);
        int i = 0;

//            conn = getConnection(url, "POST");
//            conn.setRequestProperty("accept", "text/plain");
//
//            conn.connect();
//            getResponse(conn);
    }
    catch(NullPointerException e) { System.err.println(e); } catch (IOException ex) {
        Logger.getLogger(DiceRollerClient.class.getName()).log(Level.SEVERE, null, ex);
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
