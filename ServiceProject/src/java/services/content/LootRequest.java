/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.content;

/**
 *
 * @author larry
 */
public class LootRequest {
    private String rarity;
    private String type;
    
    public String getRarity()
    {
        return rarity;
    }
    public void setRarity(String rarity)
    {
        this.rarity = rarity;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
}
