/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.encounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import services.encounter.generated.*;

/**
 *
 * @author hanli
 */
public class RandomEncounter {
	
	int[][] diffarray = {{25,50,75,100},
						 {50,100,150,200},
						 {75,150,225,400},
						 {125,250,375,500},
						 {250,500,750,1100},
						 {300,600,900,1400},
						 {350,750,1100,1700},
						 {450,900,1400,2100},
						 {550,1100,1600,2400},
						 {600,1200,1900,2800},
						 {800,1600,2400,3600},
						 {1000,2000,3000,4500},
						 {1100,2200,3400,5100},
						 {1250,2500,3800,5700},
						 {1400,2800,4300,6400},
						 {1600,3200,4800,7200},
						 {2000,3900,5900,8800},
						 {2100,4200,6300,9500},
						 {2400,4900,7300,10900},
						 {2800,5700,8500,12700}};
	
	public EncounterResponse generateEncounter(EncounterRequest req)throws IOException{
            String terrain = req.getTerrain();
            int numMonsters = req.getNumMonsters();
            int grouplvl = req.getGroupLevel();
            int groupnum = req.getNumPlayers();
            
		List<Monster> monsters = getMonsterCSV(terrain);
		
		if(numMonsters==0){
			Random rand = new Random();
			numMonsters = rand.nextInt(10)+1;
		}
		EncounterResponse ec = new EncounterResponse();
		Encounter returnEncounter = new Encounter();
		
		//get deadly encounter
		returnEncounter = getRandomEncounter(monsters,diffarray[grouplvl-1][3]*groupnum, numMonsters);
                
		returnEncounter.setDifficulty("Deadly");
		returnEncounter.setTerrain(terrain);		
		ec.addEncounter(returnEncounter);
		
		//get hard encounter
		returnEncounter = getRandomEncounter(monsters,diffarray[grouplvl-1][2]*groupnum, numMonsters);
		returnEncounter.setDifficulty("Hard");
		returnEncounter.setTerrain(terrain);		
		ec.addEncounter(returnEncounter);
		
		//get medium encounter
		returnEncounter = getRandomEncounter(monsters,diffarray[grouplvl-1][1]*groupnum, numMonsters);
		returnEncounter.setDifficulty("Medium");
		returnEncounter.setTerrain(terrain);		
		ec.addEncounter(returnEncounter);
		
		//get easy encounter
		returnEncounter = getRandomEncounter(monsters,diffarray[grouplvl-1][0]*groupnum, numMonsters);
		returnEncounter.setDifficulty("Easy");
		returnEncounter.setTerrain(terrain);		
		ec.addEncounter(returnEncounter);
		
		return ec;
	}
	
	private Encounter getRandomEncounter(List<Monster> monsters, int xp, int numMonsters){
		List<Monster> xpmonsters = new ArrayList<>();
		
		//get monsters that fit in xp range
		int xpnum = xp/numMonsters;
		int currentxp = 0;
		for(Monster monster:monsters){
			if(Integer.parseInt(monster.getXP())<=xpnum && Integer.parseInt(monster.getXP())>currentxp){
				currentxp = Integer.parseInt(monster.getXP());
				xpmonsters.clear();
				xpmonsters.add(monster);
			}
			if(Integer.parseInt(monster.getXP())== currentxp){
				xpmonsters.add(monster);
			}
		}
		Random rand = new Random();
        int randint = rand.nextInt(xpmonsters.size());
		
		Encounter encounter = new Encounter();
		
		encounter.setMonster(xpmonsters.get(randint)); //get monster
		encounter.setNumMonsters(numMonsters); //get amount of monsters
		encounter.setTotalXp(Integer.parseInt(encounter.getMonster().getXP())*numMonsters);
		
		return encounter;
	}
	
	private List<Monster> getMonsterCSV(String terrain) throws IOException{
		
                String file="resource/Any.csv"; //default to any because why not

                if(terrain.equals("Any")){ //any
			file = "resource/Any.csv";
		}else if(terrain.equals("Mountain")){ //mountain
			file = "resource/Mountain.csv"; // needs fixed // leaving for testing purposes
		}else if(terrain.equals("Underdark")){ //underdark
			file = "resource/Underdark.csv";
		}else if(terrain.equals("Underwater")){ //underwater
			file = "resource/Underwater.csv";
		}else if(terrain.equals("Grassland")){//Grassland
			file = "resource/Grassland.csv";
		}else if(terrain.equals("Arctic")){//Arctic
			file = "resource/Arctic.csv";
		}else if(terrain.equals("Desert")){//Desert
			file = "resource/Desert.csv";
		}else if(terrain.equals("Forest")){//Forest
			file = "resource/Forest.csv";
		}else if(terrain.equals("Swamp")){//Swamp
			file = "resource/Swamp.csv";
		}else if(terrain.equals("Hill")){//Hill
			file = "resource/Hill.csv";
		}else if(terrain.equals("Coastal")){//Coastal
			file = "resource/Coastal.csv";
		}
		
                InputStream inFile = this.getClass().getResourceAsStream(file);
                InputStreamReader reader = new InputStreamReader(inFile);

		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
		
		List<Monster> monsters = new ArrayList<>();
		
		for (CSVRecord record : records) {
			Monster monster = new Monster();
			monster.setName( record.get(0));
			monster.setXP(record.get(1));
			monster.setType(record.get(2));
			monster.setSize(record.get(3));
			monster.setAlignment(record.get(4));
			
			monsters.add(monster);
		}
		return monsters;	
	}
	
        public MonsterResponse getMonsters(String terrain) throws IOException
        {
            MonsterResponse res = new MonsterResponse();
            res.setMonsters(getMonsterCSV(terrain));
            return res;
        }

}
