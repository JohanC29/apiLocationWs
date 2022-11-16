
package localhost.service.schema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the localhost.service.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: localhost.service.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLocationRequest }
     * 
     */
    public GetLocationRequest createGetLocationRequest() {
        return new GetLocationRequest();
    }

    /**
     * Create an instance of {@link GetLocationResponse }
     * 
     */
    public GetLocationResponse createGetLocationResponse() {
        return new GetLocationResponse();
    }

    /**
     * Create an instance of {@link GetLocationUniqueRequest }
     * 
     */
    public GetLocationUniqueRequest createGetLocationUniqueRequest() {
        return new GetLocationUniqueRequest();
    }

    /**
     * Create an instance of {@link GetLocationUniqueResponse }
     * 
     */
    public GetLocationUniqueResponse createGetLocationUniqueResponse() {
        return new GetLocationUniqueResponse();
    }

}
