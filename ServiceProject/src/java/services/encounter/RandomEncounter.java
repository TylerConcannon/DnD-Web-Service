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
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author hanli
 */
public class RandomEncounter {
	public void generateEncounter(String terrain, int grouplvl, int groupnum)throws IOException{
		List<Monster> monsters = getCSV(terrain);
		List<Monster> encounter = new ArrayList<>();
		
		//get deadly encounter
		//get hard encounter
		//
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
			monster.setXP(record.get(1));
			monster.setType(record.get(2));
			monster.setSize(record.get(4));
			monster.setAlignment(record.get(5));
			
			monsters.add(monster);
		}
		return monsters;	
	}
	
	
	public List<Monster> editCSV(String terrain) throws IOException{
		
		String file="Any.csv"; //default to any because why not
		
		if(terrain.equals("Any")){ //any
			file = "src/java/services/encounter/Any.csv";
		}else if(terrain.equals("Mountain")){ //mountain
			file = "src/java/services/encounter/Mountain.csv"; // needs fixed // leaviong for testing purposes
		}else if(terrain.equals("Underdark")){ //underdark
			file = "src/java/services/encounter/Underdark.csv";
		}else if(terrain.equals("Underwater")){ //underwater
			file = "src/java/services/encounter/Underwater.csv";
		}else if(terrain.equals("Grassland")){//Grassland
			file = "src/java/services/encounter/Grassland.csv";
		}else if(terrain.equals("Arctic")){//Arctic
			file = "src/java/services/encounter/Arctic.csv";
		}else if(terrain.equals("Desert")){//Desert
			file = "src/java/services/encounter/Desert.csv";
		}else if(terrain.equals("Forest")){//Forest
			file = "src/java/services/encounter/Forest.csv";
		}else if(terrain.equals("Swamp")){//Swamp
			file = "src/java/services/encounter/Swamp.csv";
		}else if(terrain.equals("Hill")){//Hill
			file = "src/java/services/encounter/Hill.csv";
		}else if(terrain.equals("Coastal")){//Coastal
			file = "src/java/services/encounter/Coastal.csv";
		}
		
		Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		List<Monster> monsters = new ArrayList<>();
		
		for (CSVRecord record : records) {
			Monster monster = new Monster();			
			monster.setName( record.get(0));
			
			if(record.get(1).trim().equals("0")){
				continue;
			}
			else{
				monster.setXP(monsterConversionSwitch(record.get(1).trim())+"");
				monster.setType(record.get(2));
				monster.setSize(record.get(4));
				monster.setAlignment(record.get(5));

				monsters.add(monster);
			}		
			
		}	
		
		try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\hanli\\Google Drive\\School\\Sweng 465\\DnDWebServices\\ServiceProject\\src\\java\\services\\encounter\\newcsv\\"+terrain+".csv"));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("Name", "XP", "Type", "Size", "Alignment"));
        ) {
			for(Monster m : monsters){
				csvPrinter.printRecord(m.getName(), m.getXP(), m.getType(), m.getSize(), m.getAlignment());        
			}
            csvPrinter.flush(); 
        }		
		
		return monsters;	
	}
	
	private int monsterConversionSwitch(String cr){

		switch(cr)
		{
			case "1/8":
				return 25;
			case "1/4":
				return 50;
			case "1/2":
				return 100;
			case "1":
				return 200;
			case "2":
				return 450;
			case "3":
				return 700;
			case "4":
				return 1100;
			case "5":
				return 1800;
			case "6":
				return 2300;
			case "7":
				return 2900;
			case "8":
				return 3900;
			case "9":
				return 5000;
			case "10":
				return 5900;
			case "11":
				return 7200;
			case "12":
				return 8400;
			case "13":
				return 10000;
			case "14":
				return 11500;
			case "15":
				return 13000;
			case "16":
				return 15000;
			case "17":
				return 18000;
			case "18":
				return 20000;
			case "19":
				return 22000;
			case "20":
				return 25000;
			case "21":
				return 33000;
			case "22":
				return 41000;
			case "23":
				return 50000;
			case "24":
				return 62000;
			case "25":
				return 75000;
			case "26":
				return 90000;
			case "27":
				return 105000;
			case "28":
				return 120000;
			case "29":
				return 135000;
			case "30":
				return 155000;
		}
		return 0;
	}

}
