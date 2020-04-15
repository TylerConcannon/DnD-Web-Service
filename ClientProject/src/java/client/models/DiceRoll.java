/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanli
 */
public class DiceRoll {
    private int total;
    private List<List<Integer>> rolls;
       private int max, min;
    
    public DiceRoll(){
        rolls = new ArrayList<>();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<List<Integer>> getRolls() {
        return rolls;
    }

    public void setRolls(List<List<Integer>> rolls) {
        this.rolls = rolls;
    }
}
