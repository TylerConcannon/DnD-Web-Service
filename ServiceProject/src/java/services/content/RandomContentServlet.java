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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        
        
        int i = 0;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = 0;
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
    
//    private String getBody(HttpServletRequest request)
//    {
//        StringBuilder buffer = new StringBuilder();
//        BufferedReader reader;
//        String content = "";
//        try {
//            reader = request.getReader();
//            String line;
//            while ((line = reader.readLine()) != null)
//            {
//                buffer.append(line);
//            }
//            content = buffer.toString();
//            
//        } catch (IOException ex) {
//            Logger.getLogger(DiceRollerServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return content;
//    }
    
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
}
