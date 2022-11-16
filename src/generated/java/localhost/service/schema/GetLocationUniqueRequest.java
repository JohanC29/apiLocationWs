
package localhost.service.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="latlng" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "latlng"
})
@XmlRootElement(name = "GetLocationUniqueRequest")
public class GetLocationUniqueRequest {

    @XmlElement(required = true)
    protected String latlng;

    /**
     * Obtiene el valor de la propiedad latlng.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatlng() {
        return latlng;
    }

    /**
     * Define el valor de la propiedad latlng.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatlng(String value) {
        this.latlng = value;
    }

}
