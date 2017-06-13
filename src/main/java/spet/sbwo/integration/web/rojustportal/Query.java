package spet.sbwo.integration.web.rojustportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.7 2017-02-11T20:07:35.861+02:00
 * Generated source version: 3.1.7
 */
@WebServiceClient(name = "Query", wsdlLocation = "http://portalquery.just.ro/query.asmx?WSDL", targetNamespace =
    "portalquery.just.ro")
public class Query extends Service {
    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("portalquery.just.ro", "Query");
    public final static QName QuerySoap12 = new QName("portalquery.just.ro", "QuerySoap12");
    public final static QName QuerySoap = new QName("portalquery.just.ro", "QuerySoap");
    private static final Logger LOG = LoggerFactory.getLogger(Service.class);

    static {
        URL url = null;
        try {
            url = new URL("http://portalquery.just.ro/query.asmx?WSDL");
        } catch (MalformedURLException e) {
            LOG.info("Can not initialize the default wsdl from {}", "http://portalquery.just.ro/query.asmx?WSDL");
        }
        WSDL_LOCATION = url;
    }

    public Query(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Query(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Query() {
        super(WSDL_LOCATION, SERVICE);
    }

    public Query(WebServiceFeature... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Query(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Query(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns QuerySoap
     */
    @WebEndpoint(name = "QuerySoap12")
    public QuerySoap getQuerySoap12() {
        return super.getPort(QuerySoap12, QuerySoap.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure
     *                 on the proxy. Supported features not in the
     *                 <code>features</code> parameter will have their default
     *                 values.
     * @return returns QuerySoap
     */
    @WebEndpoint(name = "QuerySoap12")
    public QuerySoap getQuerySoap12(WebServiceFeature... features) {
        return super.getPort(QuerySoap12, QuerySoap.class, features);
    }

    /**
     * @return returns QuerySoap
     */
    @WebEndpoint(name = "QuerySoap")
    public QuerySoap getQuerySoap() {
        return super.getPort(QuerySoap, QuerySoap.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure
     *                 on the proxy. Supported features not in the
     *                 <code>features</code> parameter will have their default
     *                 values.
     * @return returns QuerySoap
     */
    @WebEndpoint(name = "QuerySoap")
    public QuerySoap getQuerySoap(WebServiceFeature... features) {
        return super.getPort(QuerySoap, QuerySoap.class, features);
    }

}
