
package services.character;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlayerCharacter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlayerCharacter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="abilityScores" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="playerClass" type="{http://character.services/}PlayerClass"/>
 *         &lt;element name="playerRace" type="{http://character.services/}PlayerRace"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlayerCharacter", propOrder = {
    "name",
    "level",
    "abilityScores",
    "playerClass",
    "playerRace"
})
public class PlayerCharacter {

    @XmlElement(required = true)
    protected String name;
    protected int level;
    @XmlElement(type = Integer.class)
    protected List<Integer> abilityScores;
    @XmlElement(required = true)
    protected PlayerClass playerClass;
    @XmlElement(required = true)
    protected PlayerRace playerRace;

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
     * Gets the value of the level property.
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * Gets the value of the abilityScores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abilityScores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbilityScores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAbilityScores() {
        if (abilityScores == null) {
            abilityScores = new ArrayList<Integer>();
        }
        return this.abilityScores;
    }

    /**
     * Gets the value of the playerClass property.
     * 
     * @return
     *     possible object is
     *     {@link PlayerClass }
     *     
     */
    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    /**
     * Sets the value of the playerClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlayerClass }
     *     
     */
    public void setPlayerClass(PlayerClass value) {
        this.playerClass = value;
    }

    /**
     * Gets the value of the playerRace property.
     * 
     * @return
     *     possible object is
     *     {@link PlayerRace }
     *     
     */
    public PlayerRace getPlayerRace() {
        return playerRace;
    }

    /**
     * Sets the value of the playerRace property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlayerRace }
     *     
     */
    public void setPlayerRace(PlayerRace value) {
        this.playerRace = value;
    }

}
