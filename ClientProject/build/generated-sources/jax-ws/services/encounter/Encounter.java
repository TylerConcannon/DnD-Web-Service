
package services.encounter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Encounter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Encounter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monster" type="{http://encounter.services/}Monster"/>
 *         &lt;element name="numMonsters" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="terrain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalXp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="difficulty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Encounter", propOrder = {
    "monster",
    "numMonsters",
    "terrain",
    "totalXp",
    "difficulty"
})
public class Encounter {

    @XmlElement(required = true)
    protected Monster monster;
    protected int numMonsters;
    @XmlElement(required = true)
    protected String terrain;
    protected int totalXp;
    @XmlElement(required = true)
    protected String difficulty;

    /**
     * Gets the value of the monster property.
     * 
     * @return
     *     possible object is
     *     {@link Monster }
     *     
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Sets the value of the monster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Monster }
     *     
     */
    public void setMonster(Monster value) {
        this.monster = value;
    }

    /**
     * Gets the value of the numMonsters property.
     * 
     */
    public int getNumMonsters() {
        return numMonsters;
    }

    /**
     * Sets the value of the numMonsters property.
     * 
     */
    public void setNumMonsters(int value) {
        this.numMonsters = value;
    }

    /**
     * Gets the value of the terrain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * Sets the value of the terrain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerrain(String value) {
        this.terrain = value;
    }

    /**
     * Gets the value of the totalXp property.
     * 
     */
    public int getTotalXp() {
        return totalXp;
    }

    /**
     * Sets the value of the totalXp property.
     * 
     */
    public void setTotalXp(int value) {
        this.totalXp = value;
    }

    /**
     * Gets the value of the difficulty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the value of the difficulty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDifficulty(String value) {
        this.difficulty = value;
    }

}
