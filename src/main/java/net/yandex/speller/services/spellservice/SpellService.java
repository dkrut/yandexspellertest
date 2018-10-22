
package net.yandex.speller.services.spellservice;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SpellService", targetNamespace = "http://speller.yandex.net/services/spellservice", wsdlLocation = "https://speller.yandex.net/services/spellservice?WSDL")
public class SpellService
    extends Service
{

    private final static URL SPELLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SPELLSERVICE_EXCEPTION;
    private final static QName SPELLSERVICE_QNAME = new QName("http://speller.yandex.net/services/spellservice", "SpellService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://speller.yandex.net/services/spellservice?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SPELLSERVICE_WSDL_LOCATION = url;
        SPELLSERVICE_EXCEPTION = e;
    }

    public SpellService() {
        super(__getWsdlLocation(), SPELLSERVICE_QNAME);
    }

    public SpellService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SPELLSERVICE_QNAME, features);
    }

    public SpellService(URL wsdlLocation) {
        super(wsdlLocation, SPELLSERVICE_QNAME);
    }

    public SpellService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SPELLSERVICE_QNAME, features);
    }

    public SpellService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SpellService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SpellServiceSoap
     */
    @WebEndpoint(name = "SpellServiceSoap")
    public SpellServiceSoap getSpellServiceSoap() {
        return super.getPort(new QName("http://speller.yandex.net/services/spellservice", "SpellServiceSoap"), SpellServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SpellServiceSoap
     */
    @WebEndpoint(name = "SpellServiceSoap")
    public SpellServiceSoap getSpellServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://speller.yandex.net/services/spellservice", "SpellServiceSoap"), SpellServiceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SPELLSERVICE_EXCEPTION!= null) {
            throw SPELLSERVICE_EXCEPTION;
        }
        return SPELLSERVICE_WSDL_LOCATION;
    }

}
