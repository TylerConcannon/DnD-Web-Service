/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

import java.util.List;

/**
 *
 * @author Me
 */
public class PlayerRace {
    private final String name;
    private final int speed; 
    private final int str;
    private final int dex;
    private final int con;
    private final int wis;
    private final int inte;
    private final int cha;
    private final int age;
    private final String size;
    private final String traits;
    private final String languages;
        
    public PlayerRace(String name, int speed, int str, int dex, int con, int inte, int wis, int cha, int age, String size, String traits, String languages){
        this.name = name;
        this.speed = speed;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.inte = inte;
        this.wis = wis;
        this.cha = cha;
        this.age = age;
        this.size = size;
        this.traits = traits;
        this.languages = languages;
    }
    
    public List<Integer> calculateAbilityScores(List<Integer> inputScores) {
        return null;
    }
    
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getWis() {
        return wis;
    }

    public int getInte() {
        return inte;
    }

    public int getCha() {
        return cha;
    }

    public int getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public String getTraits() {
        return traits;
    }

    public String getLanguages() {
        return languages;
    }
}
