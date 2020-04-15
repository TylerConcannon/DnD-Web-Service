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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   // private static final String url = "http://localhost:8084/ServiceProject/diceRoller";

    @RequestMapping("/index")
    public ModelAndView index()
    {
        return new ModelAndView("index");
    }
    
    @RequestMapping("/roll")
    public ModelAndView roll()
    {
        return new ModelAndView("roll");
    }
    
    @RequestMapping("/about")
    public ModelAndView about()
    {
        return new ModelAndView("about");
    }

    @RequestMapping("/randomCharacter")
    public ModelAndView character()
    {
        return new ModelAndView("randomCharacter");
    }
    
    @RequestMapping("/randomContent")
    public ModelAndView content()
    {
        return new ModelAndView("randomContent");
    }
    
    @RequestMapping("/randomEncounter")
    public ModelAndView encounter()
    {
        return new ModelAndView("randomEncounter");
    }
    
    @RequestMapping("/welcome")
    public ModelAndView welcome()
    {
        String message = "<br><div style='text-align:center;'>"
                            + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }
}
