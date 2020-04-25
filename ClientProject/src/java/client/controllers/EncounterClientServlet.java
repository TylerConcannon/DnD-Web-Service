/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.encounter.EncounterResponse;
import services.encounter.EncounterWS;
import services.encounter.EncounterWS_Service;
import services.encounter.GenerateEncounter.EncounterRequest;
import services.encounter.GenerateEncounterResponse;

/**
 *
 * @author larry
 */
public class EncounterClientServlet extends HttpServlet {

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
            out.println("<title>Servlet EncounterClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EncounterClientServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String content = getBody(request);
        String terrain = request.getParameter("terrain");
        String numPlayers = request.getParameter("numPlayers");
        String playerLevel = request.getParameter("playerLevel");
        String numMonsters = request.getParameter("numMonsters");
        //EncounterRequest encounter = getBody(request);
        int i = 0;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EncounterRequest encounter = getBody(request);
        GenerateEncounterResponse.Return data = sendCharacterRequest(encounter);
        sendJsonResponse(data, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
    private EncounterRequest getBody(HttpServletRequest request)
    {    
        EncounterRequest encounter = new EncounterRequest(); 
        try{
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            encounter = gson.fromJson(reader, EncounterRequest.class);
        }
        catch (Exception e){
            
        }
        return encounter;
    }
    
    private void sendJsonResponse(GenerateEncounterResponse.Return data, HttpServletResponse response)
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
    
    private GenerateEncounterResponse.Return sendCharacterRequest(EncounterRequest encounter){
        
     //   setSecurityProps();
        
        EncounterWS_Service service = new EncounterWS_Service();
        EncounterWS port = service.getEncounterWSPort();
        GenerateEncounterResponse.Return res = port.generateEncounter(encounter);
        
        return res;
    }

}
