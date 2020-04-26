/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controllers;

import client.models.DiceRoll;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.TrustSelfSignedStrategy;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.ssl.*;
import org.apache.hc.core5.http.NotImplementedException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

/**
 *
 * @author ChaseT
 */
public class DiceClientServlet extends HttpServlet {
    private static final String diceRollerUrl = "https://localhost:8443/ServiceProject/diceRoller";

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DiceClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DiceClientServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String numberDice = request.getParameter("numDice");
        String diceType = request.getParameter("diceType");
        
        DiceRoll roll = getDiceRoll(numberDice, diceType);
        DiceRoll serviceRoll = sendRequest(request, roll);
       
        sendJsonResponse(response, serviceRoll);
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private DiceRoll getDiceRoll(String numDice, String diceType)
    {
        DiceRoll roll = new DiceRoll();

        List<List<Integer>> rolls = new ArrayList<List<Integer>>();

        List<Integer> roll1 = new ArrayList<>();
        roll1.add(Integer.parseInt(diceType));
        roll1.add(Integer.parseInt(numDice));

        rolls.add(roll1);

        roll.setRolls(rolls);
        
        return roll;
    }
    
    private DiceRoll sendRequest(HttpServletRequest request, DiceRoll roll)
    {

        setSecurityProps();

        HttpClient client = HttpClients.custom().useSystemProperties().build();
        Gson payload = new Gson();
        DiceRoll serviceRoll = new DiceRoll();
        try {
             HttpGet get = new HttpGet(diceRollerUrl);
             StringEntity entity = new StringEntity(payload.toJson(roll));
             get.setEntity(entity);
             get.setHeader("Content-type", "application/json");

             ClassicHttpResponse res = (ClassicHttpResponse) client.execute(get);
             HttpEntity ent = res.getEntity();
             String str = EntityUtils.toString(ent, "UTF-8");

             Gson gson = new Gson();
             serviceRoll = gson.fromJson(str, DiceRoll.class);


       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        
       return serviceRoll;
    }
    
    private void setSecurityProps(){
        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\dnd.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "G@nda1f");
        System.setProperty("javax.net.ssl.keyStore", "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\dnd.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "G@nda1f");
    }
    
    private void sendJsonResponse(HttpServletResponse response, DiceRoll roll) throws IOException
    {
        Gson gson = new Gson();
        String payload = gson.toJson(roll);
        
        PrintWriter out = response.getWriter();
        response.addHeader("Content-type", "application/json");
        response.setCharacterEncoding("UTF-8");
        
        out.print(payload);
        out.flush();
    }
}
