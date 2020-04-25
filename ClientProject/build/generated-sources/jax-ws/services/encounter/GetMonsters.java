
package services.encounter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMonsters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMonsters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monsterRequest" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="terrain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMonsters", propOrder = {
    "monsterRequest"
})
public class GetMonsters {

    protected GetMonsters.MonsterRequest monsterRequest;

    /**
     * Gets the value of the monsterRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetMonsters.MonsterRequest }
     *     
     */
    public GetMonsters.MonsterRequest getMonsterRequest() {
        return monsterRequest;
    }

    /**
     * Sets the value of the monsterRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMonsters.MonsterRequest }
     *     
     */
    public void setMonsterRequest(GetMonsters.MonsterRequest value) {
        this.monsterRequest = value;
    }


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
        "terrain"
    })
    public static class MonsterRequest {

        @XmlElement(required = true)
        protected String terrain;

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

    }

}
