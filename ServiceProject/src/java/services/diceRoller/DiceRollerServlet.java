/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.diceRoller;

import com.google.gson.Gson;
import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author larry
 */
public class DiceRollerServlet extends HttpServlet {

    public void init(){
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Roll roll = getRoll(request);
        sendRollJson(response, roll);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

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
    
    private Roll getRoll(HttpServletRequest request)
    {
        Gson gson = new Gson();
        String content = getBody(request);
        Roll roll = gson.fromJson(content, Roll.class);

        System.out.println(roll);
        List<List<Integer>> rolls = roll.getRolls();
        System.out.println(rolls.toString());


        DiceRoller roller = new DiceRoller();
        roll = roller.rollDice(rolls);
        return roll;
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
            Logger.getLogger(DiceRollerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
    private void sendRollJson(HttpServletResponse response, Roll roll)
    {
        Gson gson = new Gson();
        String rollJson = gson.toJson(roll);
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(rollJson);
            out.flush();
                          
        } catch (IOException ex) {
            Logger.getLogger(DiceRollerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
