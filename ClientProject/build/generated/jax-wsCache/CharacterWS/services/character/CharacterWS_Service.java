
package services.character;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CharacterWS", targetNamespace = "http://character.services/", wsdlLocation = "https://localhost:8443/ServiceProject/CharacterWS?wsdl")
public class CharacterWS_Service
    extends Service
{

    private final static URL CHARACTERWS_WSDL_LOCATION;
    private final static WebServiceException CHARACTERWS_EXCEPTION;
    private final static QName CHARACTERWS_QNAME = new QName("http://character.services/", "CharacterWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://localhost:8443/ServiceProject/CharacterWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CHARACTERWS_WSDL_LOCATION = url;
        CHARACTERWS_EXCEPTION = e;
    }

    public CharacterWS_Service() {
        super(__getWsdlLocation(), CHARACTERWS_QNAME);
    }

    public CharacterWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CHARACTERWS_QNAME, features);
    }

    public CharacterWS_Service(URL wsdlLocation) {
        super(wsdlLocation, CHARACTERWS_QNAME);
    }

    public CharacterWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CHARACTERWS_QNAME, features);
    }

    public CharacterWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CharacterWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CharacterWS
     */
    @WebEndpoint(name = "CharacterWSPort")
    public CharacterWS getCharacterWSPort() {
        return super.getPort(new QName("http://character.services/", "CharacterWSPort"), CharacterWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CharacterWS
     */
    @WebEndpoint(name = "CharacterWSPort")
    public CharacterWS getCharacterWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://character.services/", "CharacterWSPort"), CharacterWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CHARACTERWS_EXCEPTION!= null) {
            throw CHARACTERWS_EXCEPTION;
        }
        return CHARACTERWS_WSDL_LOCATION;
    }

}
