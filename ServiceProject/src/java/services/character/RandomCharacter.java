/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import services.character.generated.*;
import services.diceRoller.DiceRoller;

/**
 *
 * @author Me
 */
public class RandomCharacter {
    
    
    
    public PlayerCharacter generateCharacter(CharacterRequest request) throws IOException{
        
        String inputClass = request.getPlayerClass();
        String inputRace = request.getRace();
        String name = request.getName();
        int level = request.getPlayerLevel();
        
        PlayerClass playerClass = getClass(inputClass);
        PlayerRace playerRace = getRace(inputRace);
        
        PlayerCharacter generatedCharacter = new PlayerCharacter(name, level, playerClass, playerRace);
        
        DiceRoller dice = new DiceRoller();
        List<Integer> rollScores = dice.AbilityScoreRoll();
        
        List<Integer> classScores = new ArrayList<>();
        
        switch(playerClass.getName()){
            case "Barbarian":
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                break;
                
            case "Bard":
                classScores.add(rollScores.get(5));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(0));
                break;
                
            case "Cleric":
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(5));
                break;
                
            case "Druid":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(1));
                break;
                
            case "Fighter":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                break;
                
            case "Monk":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(5));
                break;
                
            case "Paladin":
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                classScores.add(rollScores.get(1));
                break;
                
            case "Ranger":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(5));
                break;
                
            case "Rogue":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                break;
                
            case "Sorcerer":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                classScores.add(rollScores.get(0));
                break;
                
            case "Warlock":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                classScores.add(rollScores.get(0));
                break;
                
            case "Wizard":
                classScores.add(rollScores.get(2));
                classScores.add(rollScores.get(3));
                classScores.add(rollScores.get(1));
                classScores.add(rollScores.get(0));
                classScores.add(rollScores.get(4));
                classScores.add(rollScores.get(5));
                break;
        }
        
        generatedCharacter.setAbilityScores(classScores);
        
        return generatedCharacter;
    }
    
    public PlayerClass getClass(String playerClass) throws IOException{
				
                InputStream inFile = this.getClass().getResourceAsStream("Classes.csv");
		InputStreamReader in = new InputStreamReader(inFile);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		PlayerClass returnClass = null;
		
		for (CSVRecord record : records) {
                    if(record.get(0).equals(playerClass)){
                        returnClass = new PlayerClass(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4));
                        break;
                    }
		}
                
		return returnClass;	
	}
    
    public PlayerRace getRace(String playerRace) throws IOException{
				
                InputStream inFile = this.getClass().getResourceAsStream("Races.csv");
		InputStreamReader in = new InputStreamReader(inFile);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		PlayerRace returnRace = null;
		
		for (CSVRecord record : records) {
                    if(record.get(0).equals(playerRace)){
                        returnRace = new PlayerRace(record.get(0), Integer.parseInt(record.get(1)), Integer.parseInt(record.get(2)), Integer.parseInt(record.get(3)), Integer.parseInt(record.get(4)), Integer.parseInt(record.get(5)), Integer.parseInt(record.get(6)), Integer.parseInt(record.get(7)), Integer.parseInt(record.get(8)) + (int) Math.random() * Integer.parseInt(record.get(9)), record.get(10), record.get(11), record.get(12));
                        break;
                    }
		}
                
		return returnRace;	
	}
}
