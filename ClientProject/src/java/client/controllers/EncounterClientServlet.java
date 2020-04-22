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
import client.models.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EncounterRequest encounter = getBody(request);
        sendCharacterRequest(encounter);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
//    private EncounterRequest getBody(HttpServletRequest request){
//        
//        EncounterRequest encounter = new EncounterRequest();
//        try{
//            BufferedReader reader = request.getReader();
//            Gson gson = new Gson();
//            encounter = gson.fromJson(reader, EncounterRequest.class);
//        }
//        catch (Exception e){
//            
//        }
//        return encounter;
//    }
    
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
    
    private void sendCharacterRequest(EncounterRequest encounter){
        
    }

}
