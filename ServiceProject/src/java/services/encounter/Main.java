/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.encounter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import services.encounter.generated.*;

/**
 *
 * @author hanli
 */
public class Main {
	//TESTTTTT
	public static void main(String[] args) throws IOException {
		RandomEncounter rand = new RandomEncounter();
                EncounterRequest req = new EncounterRequest();
                req.setTerrain("Any");
                req.setNumMonsters(0);
                req.setNumPlayers(4);
                req.setGroupLevel(4);
		EncounterResponse enc = rand.generateEncounter(req);
//		int i=0;
//		for(Encounter en: enc.getEncounters()){
//			System.out.println("["+en.getMonster().getName()+","+en.getMonster().getXP()+","+en.getMonster().getType()+","+en.getTerrain()+","+en.getDifficulty()+","+en.getNumMonsters()+" total xp = "+en.getTotalXp()+"]");
//			i++;
//		}
		
	}
}
