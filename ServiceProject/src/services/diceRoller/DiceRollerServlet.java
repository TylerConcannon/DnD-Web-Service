/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.diceRoller;

/**
 *
 * @author larry
 */

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiceRollerServlet extends HttpServlet
{
    public void init(){
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String rolls = request.getParameter("rolls");
        System.out.println("test build deploy");
        sendResponse(request, response, rolls);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getHeader("Content-type"));
        try {
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line);
            }
            System.out.println(buffer.toString());
            Gson gson = new Gson();
            Roll roll = gson.fromJson(buffer.toString(), Roll.class);
            System.out.println(roll);
            List<List<Integer>> rolls = roll.getRolls();
          
            System.out.println(rolls.toString());
            
            DiceRoller diceRoller = new DiceRoller();
            roll = diceRoller.rollDice(rolls);
            rolls = roll.getRolls();
            
            for (List<Integer> list : rolls)
            {
                for (Integer i : list)
                {
                    System.out.println(i + " ");
                    System.out.println("\n");
                }
            }

            
        } catch (IOException ex) {
            Logger.getLogger(DiceRollerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

    }
    public void doPut(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doInfo(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doHead(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doOptions(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    private void sendResponse(HttpServletRequest request, HttpServletResponse response, Object data){
        String desired_type = request.getHeader("accept");

        // If client requests plain text or HTML, send it; else XML.
        if (desired_type.contains("text/plain"))
            sendPlain(response, data);
        else if (desired_type.contains("text/html"))
            sendHtml(response, data);
        else
            sendXml(response, data);
    }
    
        private void sendXml(HttpServletResponse response, Object data) {
        try {
            XMLEncoder enc = new XMLEncoder(response.getOutputStream());
            enc.writeObject(data.toString());
            enc.close();
        }
        catch(IOException e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    private void sendHtml(HttpServletResponse response, Object data) {
        String html_start =
            "<html><head><title>send_html response</title></head><body><div>";
        String html_end = "</div></body></html>";
        String html_doc = html_start + data.toString() + html_end;
        sendPlain(response, html_doc);
    }

    private void sendPlain(HttpServletResponse response, Object data) {
        try {
            OutputStream out = response.getOutputStream();
            out.write(data.toString().getBytes());
            out.flush();
        }
        catch(IOException e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
   
}
