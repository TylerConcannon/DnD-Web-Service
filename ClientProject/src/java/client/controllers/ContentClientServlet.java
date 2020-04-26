/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controllers;

import client.models.Loot;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

/**
 *
 * @author larry
 */
public class ContentClientServlet extends HttpServlet {
    
    private static final String contentUrl = "https://localhost:8443/ServiceProject/randomContent";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rarity = request.getParameter("rarity");
        String type = request.getParameter("type");    
        Loot loot = sendGetRequest(rarity, type);
        sendJsonResponse(response, loot);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String body = getBody(request);
            String res = sendPostRequest(body); 
            sendPostResponse(response, res);
        }  
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private String getBody(HttpServletRequest request)
    {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader;
        String content = "";
        try {
            reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line);
            }
            content = buffer.toString();
            
        } catch (IOException ex) {
            Logger.getLogger(ContentClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
        

    }

    
    private Loot sendGetRequest(String rarity, String type)
    {
        HttpClient client = HttpClientBuilder.create().build();
        Loot loot = new Loot();
        try {
            setSecurityProps();
            HttpGet get = new HttpGet(contentUrl + "?rarity=" + rarity + "&type=" + type);
            ClassicHttpResponse res = (ClassicHttpResponse) client.execute(get);
            HttpEntity ent = res.getEntity();
            String str = EntityUtils.toString(ent, "UTF-8");
            Gson gson = new Gson();
            loot = gson.fromJson(str, Loot.class);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }    
       return loot;
    }   
    private String sendPostRequest(String body) throws ParseException{
        try{
            setSecurityProps();
            HttpClient client = HttpClientBuilder.create().build();  
            HttpPost post = new HttpPost(contentUrl);
            HttpEntity payload = new StringEntity(body);
            post.setHeader("Content-type", "application/json");
            post.setEntity(payload);
            ClassicHttpResponse res = (ClassicHttpResponse) client.execute(post);
            return parseResponse(res);
        }
        catch (IOException e){
            e.printStackTrace();
            return "Error";
        }
    }
    
    private void sendPostResponse(HttpServletResponse response, String message)
    {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            String json = gson.toJson(message);
            out.print(json);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(DiceClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String parseResponse(ClassicHttpResponse res) throws IOException{
        HttpEntity ent = res.getEntity();
        InputStream in = ent.getContent();
        String str;
        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder buffer = new StringBuilder();
        while ((str = br.readLine()) != null)
        {
            buffer.append(str);
        }
        String message = buffer.toString();
        return message;
    }
    
    private void setSecurityProps(){
        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\dnd.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "G@nda1f");
        System.setProperty("javax.net.ssl.keyStore", "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\dnd.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "G@nda1f");
    }
    
    private void sendJsonResponse(HttpServletResponse response, Loot loot) throws IOException
    {
        Gson gson = new Gson();
        String payload = gson.toJson(loot);
        
        PrintWriter out = response.getWriter();
        response.addHeader("Content-type", "application/json");
        response.setCharacterEncoding("UTF-8");
        
        out.print(payload);
        out.flush();
    }
}
