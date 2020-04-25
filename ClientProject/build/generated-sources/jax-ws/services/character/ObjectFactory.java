
package services.character;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services.character package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GenerateCharacterResponse_QNAME = new QName("http://character.services/", "generateCharacterResponse");
    private final static QName _GenerateCharacter_QNAME = new QName("http://character.services/", "generateCharacter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services.character
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerateCharacter }
     * 
     */
    public GenerateCharacter createGenerateCharacter() {
        return new GenerateCharacter();
    }

    /**
     * Create an instance of {@link GenerateCharacterResponse }
     * 
     */
    public GenerateCharacterResponse createGenerateCharacterResponse() {
        return new GenerateCharacterResponse();
    }

    /**
     * Create an instance of {@link services.character.CharacterRequest }
     * 
     */
    public services.character.CharacterRequest createCharacterRequest() {
        return new services.character.CharacterRequest();
    }

    /**
     * Create an instance of {@link CharacterResponse }
     * 
     */
    public CharacterResponse createCharacterResponse() {
        return new CharacterResponse();
    }

    /**
     * Create an instance of {@link PlayerCharacter }
     * 
     */
    public PlayerCharacter createPlayerCharacter() {
        return new PlayerCharacter();
    }

    /**
     * Create an instance of {@link PlayerClass }
     * 
     */
    public PlayerClass createPlayerClass() {
        return new PlayerClass();
    }

    /**
     * Create an instance of {@link PlayerRace }
     * 
     */
    public PlayerRace createPlayerRace() {
        return new PlayerRace();
    }

    /**
     * Create an instance of {@link GenerateCharacter.CharacterRequest }
     * 
     */
    public GenerateCharacter.CharacterRequest createGenerateCharacterCharacterRequest() {
        return new GenerateCharacter.CharacterRequest();
    }

    /**
     * Create an instance of {@link GenerateCharacterResponse.Return }
     * 
     */
    public GenerateCharacterResponse.Return createGenerateCharacterResponseReturn() {
        return new GenerateCharacterResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateCharacterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://character.services/", name = "generateCharacterResponse")
    public JAXBElement<GenerateCharacterResponse> createGenerateCharacterResponse(GenerateCharacterResponse value) {
        return new JAXBElement<GenerateCharacterResponse>(_GenerateCharacterResponse_QNAME, GenerateCharacterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateCharacter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://character.services/", name = "generateCharacter")
    public JAXBElement<GenerateCharacter> createGenerateCharacter(GenerateCharacter value) {
        return new JAXBElement<GenerateCharacter>(_GenerateCharacter_QNAME, GenerateCharacter.class, null, value);
    }

}
