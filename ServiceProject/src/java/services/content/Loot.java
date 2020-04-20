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
public class Loot 
{
    private String name;
    private String description;
	private String type;
	private String value;
        private String rarity;
    
    // Setters -----------------------------------------------------------------
    public void setType(String type) {
		this.type = type;
	}
	
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public void setValue(String value) 
    {
        this.value = value;
    }
    
    // Getters -----------------------------------------------------------------
    public String getType() {
		return type;
	}
	
    public String getName() 
    {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    
    public String getDescription() 
    {
        return description;
    }
    
    public String getValue() 
    {
        return value;
    }
}
