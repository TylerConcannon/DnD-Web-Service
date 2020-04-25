
package services.character;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlayerRace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlayerRace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="str" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="con" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="wis" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="inte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cha" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="traits" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="languages" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlayerRace", propOrder = {
    "name",
    "speed",
    "str",
    "dex",
    "con",
    "wis",
    "inte",
    "cha",
    "age",
    "size",
    "traits",
    "languages"
})
public class PlayerRace {

    @XmlElement(required = true)
    protected String name;
    protected int speed;
    protected int str;
    protected int dex;
    protected int con;
    protected int wis;
    protected int inte;
    protected int cha;
    protected int age;
    @XmlElement(required = true)
    protected String size;
    @XmlElement(required = true)
    protected String traits;
    @XmlElement(required = true)
    protected String languages;

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
     * Gets the value of the speed property.
     * 
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     */
    public void setSpeed(int value) {
        this.speed = value;
    }

    /**
     * Gets the value of the str property.
     * 
     */
    public int getStr() {
        return str;
    }

    /**
     * Sets the value of the str property.
     * 
     */
    public void setStr(int value) {
        this.str = value;
    }

    /**
     * Gets the value of the dex property.
     * 
     */
    public int getDex() {
        return dex;
    }

    /**
     * Sets the value of the dex property.
     * 
     */
    public void setDex(int value) {
        this.dex = value;
    }

    /**
     * Gets the value of the con property.
     * 
     */
    public int getCon() {
        return con;
    }

    /**
     * Sets the value of the con property.
     * 
     */
    public void setCon(int value) {
        this.con = value;
    }

    /**
     * Gets the value of the wis property.
     * 
     */
    public int getWis() {
        return wis;
    }

    /**
     * Sets the value of the wis property.
     * 
     */
    public void setWis(int value) {
        this.wis = value;
    }

    /**
     * Gets the value of the inte property.
     * 
     */
    public int getInte() {
        return inte;
    }

    /**
     * Sets the value of the inte property.
     * 
     */
    public void setInte(int value) {
        this.inte = value;
    }

    /**
     * Gets the value of the cha property.
     * 
     */
    public int getCha() {
        return cha;
    }

    /**
     * Sets the value of the cha property.
     * 
     */
    public void setCha(int value) {
        this.cha = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Gets the value of the traits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraits() {
        return traits;
    }

    /**
     * Sets the value of the traits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraits(String value) {
        this.traits = value;
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguages(String value) {
        this.languages = value;
    }

}
