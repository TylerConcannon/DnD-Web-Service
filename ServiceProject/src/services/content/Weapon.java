/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.content;

/**
 *
 * @author Me
 */
public class Weapon extends Loot
{
    private String attackDie;

    public Weapon()
    {
    }
    
    public Weapon(String name, String desc, String attackDie, String gpValue)
    {
        this.setName(name);
        this.setDescription(desc);
        this.setAttackDie(attackDie);
        this.setValue(gpValue);
        
    }
    
    public void setAttackDie(String attackDie) 
    {
        this.attackDie = attackDie;
    }
    
    public String getAttackDie() 
    {
        return attackDie;
    }
}
