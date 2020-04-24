/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

/**
 *
 * @author Me
 */
public class PlayerClass {
    
    private final String name;
    private final String hitDie;
    private final String proficiencies;
    private final String savingThrows;
    private final String skills;

    public PlayerClass(String name, String hitDie, String proficiencies, String savingThrows, String skills){
        this.name = name;
        this.hitDie = hitDie;
        this.proficiencies = proficiencies;
        this.savingThrows = savingThrows;
        this.skills = skills;
    }
    
    public String getName() {
        return name;
    }

    public String getHitDie() {
        return hitDie;
    }

    public String getProficiencies() {
        return proficiencies;
    }

    public String getSavingThrows() {
        return savingThrows;
    }

    public String getSkills() {
        return skills;
    }
}
