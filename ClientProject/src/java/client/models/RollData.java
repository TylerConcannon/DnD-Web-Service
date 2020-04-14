/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.models;

/**
 *
 * @author larry
 */
public class RollData {
    private int numberOfDice;
    private int diceSides;
    
    public int getNumberOfDice()
    {
        return numberOfDice;
    }
    public void setNumberOfDice(int num)
    {
        numberOfDice = num;
    }
    public int getDiceSides()
    {
        return diceSides;
    }
    public void setDiceSides(int sides)
    {
        diceSides = sides;
    }
}
