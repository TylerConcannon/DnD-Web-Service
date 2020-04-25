
package services.encounter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services.encounter package. 
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

    private final static QName _GetMonsters_QNAME = new QName("http://encounter.services/", "getMonsters");
    private final static QName _GenerateEncounter_QNAME = new QName("http://encounter.services/", "generateEncounter");
    private final static QName _GenerateEncounterResponse_QNAME = new QName("http://encounter.services/", "generateEncounterResponse");
    private final static QName _GetMonstersResponse_QNAME = new QName("http://encounter.services/", "getMonstersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services.encounter
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMonstersResponse }
     * 
     */
    public GetMonstersResponse createGetMonstersResponse() {
        return new GetMonstersResponse();
    }

    /**
     * Create an instance of {@link GenerateEncounterResponse }
     * 
     */
    public GenerateEncounterResponse createGenerateEncounterResponse() {
        return new GenerateEncounterResponse();
    }

    /**
     * Create an instance of {@link GenerateEncounter }
     * 
     */
    public GenerateEncounter createGenerateEncounter() {
        return new GenerateEncounter();
    }

    /**
     * Create an instance of {@link GetMonsters }
     * 
     */
    public GetMonsters createGetMonsters() {
        return new GetMonsters();
    }

    /**
     * Create an instance of {@link EncounterResponse }
     * 
     */
    public EncounterResponse createEncounterResponse() {
        return new EncounterResponse();
    }

    /**
     * Create an instance of {@link Encounter }
     * 
     */
    public Encounter createEncounter() {
        return new Encounter();
    }

    /**
     * Create an instance of {@link MonsterResponse }
     * 
     */
    public MonsterResponse createMonsterResponse() {
        return new MonsterResponse();
    }

    /**
     * Create an instance of {@link Monster }
     * 
     */
    public Monster createMonster() {
        return new Monster();
    }

    /**
     * Create an instance of {@link services.encounter.EncounterRequest }
     * 
     */
    public services.encounter.EncounterRequest createEncounterRequest() {
        return new services.encounter.EncounterRequest();
    }

    /**
     * Create an instance of {@link services.encounter.MonsterRequest }
     * 
     */
    public services.encounter.MonsterRequest createMonsterRequest() {
        return new services.encounter.MonsterRequest();
    }

    /**
     * Create an instance of {@link GetMonstersResponse.Return }
     * 
     */
    public GetMonstersResponse.Return createGetMonstersResponseReturn() {
        return new GetMonstersResponse.Return();
    }

    /**
     * Create an instance of {@link GenerateEncounterResponse.Return }
     * 
     */
    public GenerateEncounterResponse.Return createGenerateEncounterResponseReturn() {
        return new GenerateEncounterResponse.Return();
    }

    /**
     * Create an instance of {@link GenerateEncounter.EncounterRequest }
     * 
     */
    public GenerateEncounter.EncounterRequest createGenerateEncounterEncounterRequest() {
        return new GenerateEncounter.EncounterRequest();
    }

    /**
     * Create an instance of {@link GetMonsters.MonsterRequest }
     * 
     */
    public GetMonsters.MonsterRequest createGetMonstersMonsterRequest() {
        return new GetMonsters.MonsterRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMonsters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://encounter.services/", name = "getMonsters")
    public JAXBElement<GetMonsters> createGetMonsters(GetMonsters value) {
        return new JAXBElement<GetMonsters>(_GetMonsters_QNAME, GetMonsters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateEncounter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://encounter.services/", name = "generateEncounter")
    public JAXBElement<GenerateEncounter> createGenerateEncounter(GenerateEncounter value) {
        return new JAXBElement<GenerateEncounter>(_GenerateEncounter_QNAME, GenerateEncounter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateEncounterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://encounter.services/", name = "generateEncounterResponse")
    public JAXBElement<GenerateEncounterResponse> createGenerateEncounterResponse(GenerateEncounterResponse value) {
        return new JAXBElement<GenerateEncounterResponse>(_GenerateEncounterResponse_QNAME, GenerateEncounterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMonstersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://encounter.services/", name = "getMonstersResponse")
    public JAXBElement<GetMonstersResponse> createGetMonstersResponse(GetMonstersResponse value) {
        return new JAXBElement<GetMonstersResponse>(_GetMonstersResponse_QNAME, GetMonstersResponse.class, null, value);
    }

}
