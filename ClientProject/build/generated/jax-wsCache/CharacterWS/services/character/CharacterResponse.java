
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
 *         &lt;element name="character" type="{http://character.services/}PlayerCharacter"/>
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
    "character"
})
@XmlRootElement(name = "CharacterResponse")
public class CharacterResponse {

    @XmlElement(required = true)
    protected PlayerCharacter character;

    /**
     * Gets the value of the character property.
     * 
     * @return
     *     possible object is
     *     {@link PlayerCharacter }
     *     
     */
    public PlayerCharacter getCharacter() {
        return character;
    }

    /**
     * Sets the value of the character property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlayerCharacter }
     *     
     */
    public void setCharacter(PlayerCharacter value) {
        this.character = value;
    }

}
