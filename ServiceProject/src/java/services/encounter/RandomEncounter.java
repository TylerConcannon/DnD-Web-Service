/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.encounter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author hanli
 */
public class RandomEncounter {
	public void generateEncounter(String terrain, int groupCR){
		
	}
	
	public List<Monster> getCSV(String terrain) throws IOException{
		
		String file="Any.csv"; //default to any because why not
		
		if(terrain.equals("Any")){ //any
			file = "resource/Any.csv";
		}else if(terrain.equals("Mountain")){ //mountain
			file = "src/java/services/encounter/Mountain.csv"; // needs fixed // leaviong for testing purposes
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
		
		Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		List<Monster> monsters = new ArrayList<>();
		
		for (CSVRecord record : records) {
			Monster monster = new Monster();
			monster.setName( record.get(0));
			monster.setCR(record.get(1));
			monster.setType(record.get(2));
			monster.setSize(record.get(4));
			monster.setAlignment(record.get(5));
			
			monsters.add(monster);
		}
		return monsters;	
	}
}
