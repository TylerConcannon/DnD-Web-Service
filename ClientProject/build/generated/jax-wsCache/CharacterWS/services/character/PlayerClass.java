
package services.character;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlayerClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlayerClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hitDie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="proficiencies" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="savingThrows" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="skills" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlayerClass", propOrder = {
    "name",
    "hitDie",
    "proficiencies",
    "savingThrows",
    "skills"
})
public class PlayerClass {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String hitDie;
    @XmlElement(required = true)
    protected String proficiencies;
    @XmlElement(required = true)
    protected String savingThrows;
    @XmlElement(required = true)
    protected String skills;

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
     * Gets the value of the hitDie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHitDie() {
        return hitDie;
    }

    /**
     * Sets the value of the hitDie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHitDie(String value) {
        this.hitDie = value;
    }

    /**
     * Gets the value of the proficiencies property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProficiencies() {
        return proficiencies;
    }

    /**
     * Sets the value of the proficiencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProficiencies(String value) {
        this.proficiencies = value;
    }

    /**
     * Gets the value of the savingThrows property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSavingThrows() {
        return savingThrows;
    }

    /**
     * Sets the value of the savingThrows property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSavingThrows(String value) {
        this.savingThrows = value;
    }

    /**
     * Gets the value of the skills property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Sets the value of the skills property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkills(String value) {
        this.skills = value;
    }

}
