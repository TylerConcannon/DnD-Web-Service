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
		List<Monster> returnItems = rand.getCSV("Mountain");
		
		for(Monster l: returnItems){
			System.out.println("["+l.getName()+","+l.getCR()+","+l.getType()+","+l.getAlignment()+","+l.getSize()+"]");
		}
		
	}
}
