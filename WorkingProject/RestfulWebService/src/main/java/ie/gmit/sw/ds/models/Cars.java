//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.12.10 at 11:47:37 AM GMT 
//


package ie.gmit.sw.ds.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cars complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cars"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="carMake" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carModel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cars", namespace = "http://ds.sw.gmit.ie/models/", propOrder = {
    "carMake",
    "carModel"
})
public class Cars implements Serializable{

    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String carMake;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String carModel;

    /**
     * Gets the value of the carMake property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarMake() {
        return carMake;
    }

    /**
     * Sets the value of the carMake property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarMake(String value) {
        this.carMake = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarModel(String value) {
        this.carModel = value;
    }

}
