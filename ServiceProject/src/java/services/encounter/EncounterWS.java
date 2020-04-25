/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.encounter;

import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import services.encounter.generated.*;

/**
 *
 * @author larry
 */
@WebService(serviceName = "EncounterWS")
public class EncounterWS {

    /**
     * Web service operation
     * @param encounterReq
     * @return services.encounter.generated.EncounterResponse
     */
    @WebMethod(operationName = "generateEncounter")
    public EncounterResponse generateEncounter(@WebParam(name = "EncounterRequest") EncounterRequest encounterReq) {
        RandomEncounter random = new RandomEncounter();
        EncounterResponse res = new EncounterResponse();
        try {
            res = random.generateEncounter(encounterReq);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMonsters")
    public MonsterResponse getMonsters(@WebParam(name = "monsterRequest") MonsterRequest monsterRequest) {
        
        RandomEncounter random = new RandomEncounter();
        MonsterResponse res = new MonsterResponse();
        try{
            
            res = random.getMonsters(monsterRequest.getTerrain());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }    
        return res;
    }


}
