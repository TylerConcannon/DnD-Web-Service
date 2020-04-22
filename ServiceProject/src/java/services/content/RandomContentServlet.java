/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.content;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import org.apache.hc.core5.http.HttpException;
import services.diceRoller.DiceRoller;
import services.diceRoller.DiceRollerServlet;
import services.diceRoller.Roll;

/**
 *
 * @author larry
 */
public class RandomContentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Loot> loot = getLoot(request);
        sendContentJson(response, loot);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Loot content = getBody(request);
        String status = postNewContent(content) ? "Successfully posted your Loot!" : "Error posting your loot";
        sendResponse(response, status);
    }


    private List<Loot> getLoot(HttpServletRequest request) throws IOException
    {
        String rarity = request.getParameter("rarity");
        String type = request.getParameter("type");
        
        RandomContent content = new RandomContent();
        List<Loot> loot = new ArrayList<>();
        loot = content.generateLoot(rarity, type, 1);
        
        return loot;
    }
    
    private Loot getBody(HttpServletRequest request)
    {

        Loot loot = new Loot(); 
        try{
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            loot = gson.fromJson(reader, Loot.class);
        }
        catch (Exception e){
            
        }
        return loot;
        
    }
    
    private boolean postNewContent(Loot loot){
        boolean success;
        try {
            RandomContent randomContent = new RandomContent();
            success = randomContent.postContent(loot);
            return success;
        }
        catch(Exception e)
        {
            Logger.getLogger(RandomContentServlet.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } 
    }
    
    private void sendContentJson(HttpServletResponse response, List<Loot> loot)
    {
        Gson gson = new Gson();
        String rollJson = gson.toJson(loot.get(0));
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
    
    private void sendResponse(HttpServletResponse response, String message)
    {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            out.print(message);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(RandomContentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
