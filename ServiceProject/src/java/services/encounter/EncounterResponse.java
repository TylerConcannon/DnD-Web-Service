/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.encounter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author larry
 */
public class EncounterResponse {
    private List<Encounter> encounters = new ArrayList<>();

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }
	
	public void addEncounter(Encounter e){
		encounters.add(e);
	}
    
    
}
