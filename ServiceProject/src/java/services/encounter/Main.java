/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.encounter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanli
 */
public class Main {
	//TESTTTTT
	public static void main(String[] args) throws IOException {
		RandomEncounter rand = new RandomEncounter();
		EncounterResponse enc = rand.generateEncounter("Mountain",1,1,1);
		int i=0;
		for(Encounter en: enc.getEncounters()){
			System.out.println("["+en.getMonster().getName()+","+en.getMonster().getXP()+","+en.getMonster().getType()+","+en.getTerrain()+","+en.getDifficulty()+","+en.getNumMonsters()+" total xp = "+en.getTotalXp()+"]");
			i++;
		}
		
	}
}
