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
public class Character {
    
    private final String name;
    private final int level;
    private List<Integer> abilityScores;
    private final PlayerClass playerClass;
    private final PlayerRace playerRace;
    
    public Character(String name, int level, PlayerClass playerClass, PlayerRace playerRace){
        this.name = name;
        this.level = level;
        this.playerClass = playerClass;
        this.playerRace = playerRace;
    }
    
    public void setAbilityScores(List<Integer> inputScores){
        this.abilityScores = playerRace.calculateAbilityScores(inputScores);
    }
    
    public String getName(){
        return name;
    }
    
    public int getLevel(){
        return level;
    }
    
    public PlayerClass getPlayerClass(){
        return playerClass;
    }
    
    public PlayerRace getPlayerRace(){
        return playerRace;
    }
    
    public List<Integer> getAbilityScores() {
        return abilityScores;
    }
}
