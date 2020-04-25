/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

import java.io.IOException;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import services.character.generated.CharacterRequest;
import services.character.generated.CharacterResponse;
import services.character.generated.PlayerCharacter;

/**
 *
 * @author larry
 */
@WebService(serviceName = "CharacterWS")
@HandlerChain(file = "CharacterWS_handler_1.xml")
public class CharacterWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "generateCharacter")
    public CharacterResponse generateCharacter(@WebParam(name = "characterRequest") CharacterRequest characterRequest) {
        
        CharacterResponse response = new CharacterResponse();
        
        try {
            RandomCharacter characterGen = new RandomCharacter();
            PlayerCharacter character = characterGen.generateCharacter(characterRequest);
            response = new CharacterResponse();
            response.setCharacter(character);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return response;
    }

    
}
