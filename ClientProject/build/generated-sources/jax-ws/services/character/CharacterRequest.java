
package services.character;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="playerClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="race" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="playerLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "playerClass",
    "name",
    "race",
    "playerLevel"
})
@XmlRootElement(name = "CharacterRequest")
public class CharacterRequest {

    @XmlElement(required = true)
    protected String playerClass;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String race;
    protected int playerLevel;

    /**
     * Gets the value of the playerClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlayerClass() {
        return playerClass;
    }

    /**
     * Sets the value of the playerClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlayerClass(String value) {
        this.playerClass = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the race property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the value of the race property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRace(String value) {
        this.race = value;
    }

    /**
     * Gets the value of the playerLevel property.
     * 
     */
    public int getPlayerLevel() {
        return playerLevel;
    }

    /**
     * Sets the value of the playerLevel property.
     * 
     */
    public void setPlayerLevel(int value) {
        this.playerLevel = value;
    }

}
