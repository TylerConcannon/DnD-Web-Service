
package services.encounter;

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
 *         &lt;element name="terrain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numPlayers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numMonsters" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "terrain",
    "groupLevel",
    "numPlayers",
    "numMonsters"
})
@XmlRootElement(name = "EncounterRequest")
public class EncounterRequest {

    @XmlElement(required = true)
    protected String terrain;
    protected int groupLevel;
    protected int numPlayers;
    protected int numMonsters;

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
     * Gets the value of the groupLevel property.
     * 
     */
    public int getGroupLevel() {
        return groupLevel;
    }

    /**
     * Sets the value of the groupLevel property.
     * 
     */
    public void setGroupLevel(int value) {
        this.groupLevel = value;
    }

    /**
     * Gets the value of the numPlayers property.
     * 
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Sets the value of the numPlayers property.
     * 
     */
    public void setNumPlayers(int value) {
        this.numPlayers = value;
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

}
