/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanli
 */
public class Roll {
    private int total;
    private List<List<Integer>> rolls = new ArrayList<>();
    
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
