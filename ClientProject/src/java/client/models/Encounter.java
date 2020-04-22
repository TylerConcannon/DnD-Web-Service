/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.models;

import java.util.List;

/**
 *
 * @author hanli
 */
public class Encounter {
    private List<Monster> monsters;
    private int numMonsters;
    private String terrain;
    private int totalXp;

    public int getTotalXp() {
        return totalXp;
    }

    public void setTotalXp(int totalXp) {
        this.totalXp = totalXp;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public int getNumMonsters() {
        return numMonsters;
    }

    public void setNumMonsters(int numMonsters) {
        this.numMonsters = numMonsters;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    
}
