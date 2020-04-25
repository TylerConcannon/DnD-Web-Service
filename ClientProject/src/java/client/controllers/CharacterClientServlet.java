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
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import services.character.CharacterWS_Service;
import services.character.*;
import services.character.GenerateCharacterResponse;

import services.encounter.GenerateEncounterResponse;

/**
 *
 * @author larry
 */
public class CharacterClientServlet extends HttpServlet {
    private static final String endpoint = "https://localhost:8443/ServiceProject/CharacterWS";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CharacterClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CharacterClientServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String content = getBody(request);
        int i = 0;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharacterRequest characterReq = getBody(request);
        GenerateCharacterResponse.Return character = sendCharacterRequest(characterReq);
        sendJsonResponse(character, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private CharacterRequest getBody(HttpServletRequest request)
    {  
        CharacterRequest character = new CharacterRequest(); 
        try{
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            character = gson.fromJson(reader, CharacterRequest.class);
        }
        catch (Exception e){

        }
        return character;
    }
    
    private void sendJsonResponse(GenerateCharacterResponse.Return data, HttpServletResponse response)
    {
        try {
            
            Gson gson = new Gson();
            String payload = gson.toJson(data);
        
            PrintWriter out = response.getWriter();
            response.addHeader("Content-type", "application/json");
            response.setCharacterEncoding("UTF-8");

            out.print(payload);
            out.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
       
    private void setSecurityProps(){
        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\dnd.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "G@nda1f");
        System.setProperty("javax.net.ssl.keyStore", "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\dnd.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "G@nda1f");
    } 
    
    private GenerateCharacterResponse.Return sendCharacterRequest(CharacterRequest character){
        
        GenerateCharacter.CharacterRequest req = new GenerateCharacter.CharacterRequest();

        req.setName(character.getName());
        req.setPlayerClass(character.getPlayerClass());
        req.setPlayerLevel(character.getPlayerLevel());
        req.setRace(character.getRace());
        
        setSecurityProps();
        
        CharacterWS_Service service = new CharacterWS_Service();
        CharacterWS port = service.getCharacterWSPort();
       
        GenerateCharacterResponse.Return res = port.generateCharacter(req);
        
        return res;
    }

}
