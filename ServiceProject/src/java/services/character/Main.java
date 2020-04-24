/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import services.encounter.RandomEncounter;
import services.encounter.generated.*;

/**
 *
 * @author hanli
 */
public class Main {
	//TESTTTTT
	public static void main(String[] args) throws IOException {
                
                RandomCharacter rc = new RandomCharacter();
                
                Character ch = rc.generateCharacter("Penis Dick", 10, "Bard", "Human");
		
                System.out.println(ch.getName());
                System.out.println(ch.getLevel());
                
                System.out.println();
                
                System.out.println(ch.getPlayerClass().getName());
                System.out.println(ch.getPlayerClass().getHitDie());
                System.out.println(ch.getPlayerClass().getProficiencies());
                System.out.println(ch.getPlayerClass().getSavingThrows());
                System.out.println(ch.getPlayerClass().getSkills());
                
                System.out.println();
                
                System.out.println(ch.getPlayerRace().getName());
                System.out.println(ch.getPlayerRace().getSpeed());
                System.out.println(ch.getPlayerRace().getSize());
                System.out.println(ch.getPlayerRace().getTraits());
                System.out.println(ch.getPlayerRace().getLanguages());
                
                System.out.println();
                
                System.out.println(ch.getAbilityScores());
	}
}
