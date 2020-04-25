
package services.character;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CharacterWS", targetNamespace = "http://character.services/")
@HandlerChain(file = "CharacterWS_handler.xml")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CharacterWS {


    /**
     * 
     * @param characterRequest
     * @return
     *     returns services.character.GenerateCharacterResponse.Return
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generateCharacter", targetNamespace = "http://character.services/", className = "services.character.GenerateCharacter")
    @ResponseWrapper(localName = "generateCharacterResponse", targetNamespace = "http://character.services/", className = "services.character.GenerateCharacterResponse")
    @Action(input = "http://character.services/CharacterWS/generateCharacterRequest", output = "http://character.services/CharacterWS/generateCharacterResponse")
    public services.character.GenerateCharacterResponse.Return generateCharacter(
        @WebParam(name = "characterRequest", targetNamespace = "")
        services.character.GenerateCharacter.CharacterRequest characterRequest);

}
