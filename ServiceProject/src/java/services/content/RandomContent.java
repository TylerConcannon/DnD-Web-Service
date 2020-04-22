/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.content;


import java.io.BufferedWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.*;
import org.apache.commons.csv.CSVPrinter;
import services.diceRoller.DiceRoller;
import services.diceRoller.Roll;

/**
 *
 * @author Me
 */

//Item types:
/*  Wondrous Item
    Book
    Weapon
    Treasure
    Armor
*/

public class RandomContent 
{
	List<Loot> mundaneItems = new ArrayList<>();
	List<Loot> commonItems = new ArrayList<>();
	List<Loot> rareItems = new ArrayList<>();
	List<Loot> veryRareItems = new ArrayList<>();
	List<Loot> legendaryItems = new ArrayList<>();
        
    
    List<List<String>> simpleMelee = asList
    ( 
            asList("Club", "A thick stick.", "1d4 Bludgeoning", "1 sp"),
            asList("Dagger", "A simple dagger.", "1d4 Piercing", "2 sp"),
            asList("GreatClub", "A thicker stick.", "1d8 Bludgeoning", "2 sp"),
            asList("Handaxe", "A simple handaxe.", "1d6 Slashing", "5 gp"),
            asList("Javelin", "A melee/throwing spear.", "1d6 Piercing", "5 sp"),
            asList("Light Hammer", "A hammer.", "1d4 Bludgeoning", "2 gp"),
            asList("Mace", "A simple mace.", "1d6 Bludgeoning", "5 gp"), 
            asList("Quarterstaff", "A simple quarterstaff.", "1d6 Bludgeoning", "2 sp"),
            asList("Sickle", "A curved circular one-edge blade.", "1d4 Slashing", "1 gp"),
            asList("Spear", "A simple spear.", "1d6 Piercing", "1 gp")
    );
    
    
    
    List<List<String>> simpleRanged= asList
    ( 
            asList("Darts", "A throwing dart.", "1d4 Piercing", "25 gp"), 
            asList("Shortbow", "A ranged device for firing arrows.", "1d6 Piercing", "5 cp"),
            asList("Crossbow", "A ranged device for firing bolts.", "1d8 Piercing", "25 gp"),
            asList("Sling", "A ranged device for throwing stones.", "1d4 Bludgeoning", "1 sp") 
    );
    
    
    
    List<List<String>> martialMelee = asList
    ( 
            asList("Battleaxe", "A large axe.", "1d8 Slashing", "10 gp"),
            asList("Flail", "A mass chained to a handle.", "1d8 Bludgeoning", "10 gp"),
            asList("Glaive", "A distance-based axe/spear hybrid.", "1d10 Slashing", "20 gp"),
            asList("Greataxe", "A large axe.", "1d12 Slashing", "30 gp"),
            asList("Greatsword", "A two-handed large, heavy sword.", "2d6 Slashing", "50 gp"), 
            asList("Halberd", "A distance pike/axe hybrid.", "1d10 Slashing", "20 gp"),
            asList("Lance", "A distance-based calvary spear.", "1d12 Piercing", "10 gp"),
            asList("Longsword", "A one/two handed long sword.", "1d8 Slashing", "15 gp"),
            asList("Maul", "A long handled hammer/axe hybrid.", "2d6 Bludgeoning", "10 gp"),
            asList("Mornignstar", "A spkied ball on a handle.", "1d8 Piercing", "15 gp"),
            asList("Pike", "A large, two-handed spear.", "1d10 Piercing", "15 gp"),
            asList("Rapier", "A thin, finesse sword.", "1d8 Piercing", "25 gp"), 
            asList("Scimitar", "A curved, one-edged sword.", "1d6 Slashing", "25 gp"),
            asList("Shortsword", "A shorter, one-handed sword.", "1d6 Piercing", "10 gp"),
            asList("Trident", "A three-pronged spear.", "1d6 Piercing", "5 gp"),
            asList("War Pick", "A hammer with a spiked back.", "1d8 Piercing", "5 gp"),
            asList("Warhammer", "A long hammer with a large head.", "1d8 Bludgeoning", "15 gp"),
            asList("Whip", "A rope with a handle.", "1d4 Slashing", "2 gp")
    );
    
    
    
    List<List<String>> martialRanged = asList
    ( 
            asList("Blowgun", "A ranged weapon for firing darts.", "1 Piercing", "10 gp"), 
            asList("Hand Crossbow", "A one-handed, smaller crossbow.", "1d6 Piercing", "75 gp"),
            asList("Heavy Crossbow", "A two-handed, larger crossbow.", "1d10 Piercing", "50 gp"), 
            asList("Longbow", "A bow for firing longer distances.", "1d8 Piercing", "50 gp"),
            asList("Net", "A large net.", "Used for ensnaring targets, not damage", "1 gp")
    );
    
    
    
    public Weapon generateWeapon(String rarity, String weaponType)
    {
        switch(weaponType)
        {
            case "simpleMelee":
                return simpleMelee(rarity);
                
            case "simpleRanged":
                return simpleRanged(rarity);
                
            case "martialMelee":
                return martialMelee(rarity);
                
            case "martialRanged":
                return martialRanged(rarity);
                
            default:
                return new Weapon();
        }
    }
    
    
    
    public List<Loot> generateLoot(String rarity, String type, int amt) throws IOException
    {
		setLoot(); // set loot lists
		
		List<Loot> rarityItems = new ArrayList<>();
		
		switch(rarity){
			case "Mundane":
				rarityItems.addAll(mundaneItems);
				break;
			case "Common":
				rarityItems = commonItems;
				break;
			case "Rare":
				rarityItems = rareItems;
				break;
			case "VeryRare":
				rarityItems = veryRareItems;
				break;
			case "Legendary":
				rarityItems = legendaryItems;
				break;	
		}
		
		List<Loot> lootItems = new ArrayList<>();
		
		for(Loot l: rarityItems){
                   
			if(l.getType().equals(type)){
				lootItems.add(l);
			}
		}	
		
		List<Loot> returnItems = new ArrayList<>();
		DiceRoller diceRoller = new DiceRoller();

		
		for(int i = 0; i < amt; i++){
			Roll randomNumber = diceRoller.rollDice(asList(asList(lootItems.size(), 1)));
			returnItems.add(lootItems.get(randomNumber.getTotal()-1));
		}
		
        return returnItems;
    }
    
    
    
    // Weapon Generators -----------------------------------------------------------------------------------------------------------
    private Weapon simpleMelee(String rarity)
    {
        DiceRoller diceRoller = new DiceRoller();
        Roll randomNumber = diceRoller.rollDice(asList(asList(99, 1)));
        
        if(randomNumber.getTotal() == 1)                    {return setWeaponValues(simpleMelee.get(0), rarity);}
        else if(isBetween(randomNumber.getTotal(), 2, 50))  {return setWeaponValues(simpleMelee.get(1), rarity);}
        else if(randomNumber.getTotal() == 51)              {return setWeaponValues(simpleMelee.get(2), rarity);}
        else if(isBetween(randomNumber.getTotal(), 52, 61)) {return setWeaponValues(simpleMelee.get(3), rarity);}
        else if(isBetween(randomNumber.getTotal(), 62, 71)) {return setWeaponValues(simpleMelee.get(4), rarity);}
        else if(isBetween(randomNumber.getTotal(), 72, 75)) {return setWeaponValues(simpleMelee.get(5), rarity);}
        else if(isBetween(randomNumber.getTotal(), 76, 85)) {return setWeaponValues(simpleMelee.get(6), rarity);}
        else if(isBetween(randomNumber.getTotal(), 86, 89)) {return setWeaponValues(simpleMelee.get(7), rarity);}
        else if(randomNumber.getTotal() == 90)              {return setWeaponValues(simpleMelee.get(8), rarity);}
        else                                                {return setWeaponValues(simpleMelee.get(9), rarity);}
    }
    
    
    
    private Weapon simpleRanged(String rarity)
    {
        DiceRoller diceRoller = new DiceRoller();
        Roll randomNumber = diceRoller.rollDice(asList(asList(99, 1)));
        
        if(isBetween(randomNumber.getTotal(), 1, 30))       {return setWeaponValues(simpleRanged.get(0), rarity);}
        else if(isBetween(randomNumber.getTotal(), 31, 33)) {return setWeaponValues(simpleRanged.get(1), rarity);}
        else if(isBetween(randomNumber.getTotal(), 34, 96)) {return setWeaponValues(simpleRanged.get(2), rarity);}
        else                                                {return setWeaponValues(simpleRanged.get(3), rarity);}
    }
    
    
    
    private Weapon martialMelee(String rarity)
    {
        DiceRoller diceRoller = new DiceRoller();
        Roll randomNumber = diceRoller.rollDice(asList(asList(99, 1)));
        
        if(isBetween(randomNumber.getTotal(), 1, 3))        {return setWeaponValues(martialMelee.get(0), rarity);}
        else if(randomNumber.getTotal() == 4)               {return setWeaponValues(martialMelee.get(1), rarity);}
        else if(randomNumber.getTotal() == 5)               {return setWeaponValues(martialMelee.get(2), rarity);}
        else if(isBetween(randomNumber.getTotal(), 6, 12))  {return setWeaponValues(martialMelee.get(3), rarity);}
        else if(isBetween(randomNumber.getTotal(), 13, 32)) {return setWeaponValues(martialMelee.get(4), rarity);}
        else if(isBetween(randomNumber.getTotal(), 33, 34)) {return setWeaponValues(martialMelee.get(5), rarity);}
        else if(randomNumber.getTotal() == 35)              {return setWeaponValues(martialMelee.get(6), rarity);}
        else if(isBetween(randomNumber.getTotal(), 36, 85)) {return setWeaponValues(martialMelee.get(7), rarity);}
        else if(randomNumber.getTotal() == 86)              {return setWeaponValues(martialMelee.get(8), rarity);}
        else if(randomNumber.getTotal() == 87)              {return setWeaponValues(martialMelee.get(9), rarity);}
        else if(randomNumber.getTotal() == 88)              {return setWeaponValues(martialMelee.get(10), rarity);}
        else if(isBetween(randomNumber.getTotal(), 89, 92)) {return setWeaponValues(martialMelee.get(11), rarity);}
        else if(randomNumber.getTotal() == 93)              {return setWeaponValues(martialMelee.get(12), rarity);}
        else if(randomNumber.getTotal() == 94)              {return setWeaponValues(martialMelee.get(13), rarity);}
        else if(randomNumber.getTotal() == 95)              {return setWeaponValues(martialMelee.get(14), rarity);}
        else if(randomNumber.getTotal() == 96)              {return setWeaponValues(martialMelee.get(15), rarity);}
        else if(isBetween(randomNumber.getTotal(), 97, 98)) {return setWeaponValues(martialMelee.get(16), rarity);}
        else                                                {return setWeaponValues(martialMelee.get(17), rarity);}
    }
    
    
    
    private Weapon martialRanged(String rarity)
    {
        DiceRoller diceRoller = new DiceRoller();
        Roll randomNumber = diceRoller.rollDice(asList(asList(99, 1)));
        
        if(randomNumber.getTotal() == 1)                    {return setWeaponValues(martialRanged.get(0), rarity);}
        else if(isBetween(randomNumber.getTotal(), 2, 4))   {return setWeaponValues(martialRanged.get(1), rarity);}
        else if(isBetween(randomNumber.getTotal(), 5, 31))  {return setWeaponValues(martialRanged.get(2), rarity);}
        else if(isBetween(randomNumber.getTotal(), 32, 98)) {return setWeaponValues(martialRanged.get(3), rarity);}
        else                                                {return setWeaponValues(martialRanged.get(4), rarity);}
    }
    
    
    
    // Functional Functions --------------------------------------------------------------------------------------------------------
    private boolean isBetween(int x, int lower, int upper) 
    {   
        return lower <= x && x <= upper; 
    }
    
    
    
    private Weapon setWeaponValues(List<String> valuesString, String rarity)
    {
        String totalDamage = "";
        String totalValue = "";
        
        switch (rarity)
        {
            case "Common":
                totalDamage = valuesString.get(2);
                totalValue = valuesString.get(3);
                break;
            
            case "Uncommon":
                totalDamage = valuesString.get(2) + " + 1d4";
                totalValue = valuesString.get(3) + " + [5-10] gp";
                break;
                
            case "Rare":
                totalDamage = valuesString.get(2) + " + 1d6";
                totalValue = valuesString.get(3) + " + [25-100] gp";
                break;
                
            case "VeryRare":
                totalDamage = valuesString.get(2) + " + 1d10";
                totalValue = valuesString.get(3) + " + [200-500] gp";
                break;
                
            case "Legendary":
                totalDamage = valuesString.get(2) + " + 1d20";
                totalValue = valuesString.get(3) + " + [1000+] gp";
                break;
        }
        return new Weapon(valuesString.get(0), valuesString.get(1), totalDamage, totalValue);
    }
	
	
	
	public void setLoot() throws IOException {

            InputStream inFile = this.getClass().getResourceAsStream("LootTable.csv");
            //String file = "resource/LootTable.csv";

            InputStreamReader reader = new InputStreamReader(inFile);
            //Reader in = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);

            for (CSVRecord record : records) {
                Loot loot = new Loot();
                loot.setName( record.get(0));			
                loot.setDescription(record.get(1)+ record.get(6)); //description and properties
                loot.setValue(record.get(2)); //value
                String type = record.get(5);
                type = type.replaceAll(" ", "");
                loot.setType(type);
                String rarity = record.get(3);

                if(rarity.equals("Mundane")){
                        mundaneItems.add(loot);
                }else
                if(rarity.equals("Common")){
                        commonItems.add(loot);
                }else
                if(rarity.equals("Rare")){
                        rareItems.add(loot);
                }else
                if(rarity.equals("Very Rare")){
                        veryRareItems.add(loot);
                }else
                if(rarity.equals("Legendary")){
                        legendaryItems.add(loot);
                }			
            }
            int i = 0;
	}
        
        public boolean postContent(Loot loot) throws URISyntaxException, IOException
        {
            try {
                //add loot object to csv
                URL url = this.getClass().getResource("LootTable.csv");
                URI uri = url.toURI();
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(uri), StandardOpenOption.APPEND);
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
                printer.printRecord(loot.getName(), loot.getDescription(), loot.getValue(), loot.getRarity(), "", loot.getType(), "", "", "", "");
                printer.close();
                writer.close();
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }

        }
}
