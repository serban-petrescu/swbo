package spet.sbwo.integration.web.rojustportal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-02-11T20:07:35.851+02:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "portalquery.just.ro", name = "QuerySoap")
@XmlSeeAlso({ObjectFactory.class})
public interface QuerySoap {

    /**
     * Cautare sedinte dupa data, institutie
     */
    @WebMethod(operationName = "CautareSedinte", action = "portalquery.just.ro/CautareSedinte")
    @RequestWrapper(localName = "CautareSedinte", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.CautareSedinte")
    @ResponseWrapper(localName = "CautareSedinteResponse", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.CautareSedinteResponse")
    @WebResult(name = "CautareSedinteResult", targetNamespace = "portalquery.just.ro")
    public spet.sbwo.integration.web.rojustportal.ArrayOfSedinta cautareSedinte(
        @WebParam(name = "dataSedinta", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataSedinta,
        @WebParam(name = "institutie", targetNamespace = "portalquery.just.ro")
        spet.sbwo.integration.web.rojustportal.Institutie institutie
    );

    @WebMethod(operationName = "HelloWorld", action = "portalquery.just.ro/HelloWorld")
    @RequestWrapper(localName = "HelloWorld", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.HelloWorld")
    @ResponseWrapper(localName = "HelloWorldResponse", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.HelloWorldResponse")
    @WebResult(name = "HelloWorldResult", targetNamespace = "portalquery.just.ro")
    public java.lang.String helloWorld();

    /**
     * Cautare dosare dupa numar, obiect, parte, institutie, data
     */
    @WebMethod(operationName = "CautareDosare", action = "portalquery.just.ro/CautareDosare")
    @RequestWrapper(localName = "CautareDosare", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.CautareDosare")
    @ResponseWrapper(localName = "CautareDosareResponse", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.CautareDosareResponse")
    @WebResult(name = "CautareDosareResult", targetNamespace = "portalquery.just.ro")
    public spet.sbwo.integration.web.rojustportal.ArrayOfDosar cautareDosare(
        @WebParam(name = "numarDosar", targetNamespace = "portalquery.just.ro")
        java.lang.String numarDosar,
        @WebParam(name = "obiectDosar", targetNamespace = "portalquery.just.ro")
        java.lang.String obiectDosar,
        @WebParam(name = "numeParte", targetNamespace = "portalquery.just.ro")
        java.lang.String numeParte,
        @WebParam(name = "institutie", targetNamespace = "portalquery.just.ro")
        spet.sbwo.integration.web.rojustportal.Institutie institutie,
        @WebParam(name = "dataStart", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataStart,
        @WebParam(name = "dataStop", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataStop
    );

    /**
     * Cautare dosare dupa numar, obiect, parte, institutie, data, data ultima modificare
     */
    @WebMethod(operationName = "CautareDosare2", action = "portalquery.just.ro/CautareDosare2")
    @RequestWrapper(localName = "CautareDosare2", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.CautareDosare2")
    @ResponseWrapper(localName = "CautareDosare2Response", targetNamespace = "portalquery.just.ro", className = "ro.just.portalquery.CautareDosare2Response")
    @WebResult(name = "CautareDosare2Result", targetNamespace = "portalquery.just.ro")
    public spet.sbwo.integration.web.rojustportal.ArrayOfDosar cautareDosare2(
        @WebParam(name = "numarDosar", targetNamespace = "portalquery.just.ro")
        java.lang.String numarDosar,
        @WebParam(name = "obiectDosar", targetNamespace = "portalquery.just.ro")
        java.lang.String obiectDosar,
        @WebParam(name = "numeParte", targetNamespace = "portalquery.just.ro")
        java.lang.String numeParte,
        @WebParam(name = "institutie", targetNamespace = "portalquery.just.ro")
        spet.sbwo.integration.web.rojustportal.Institutie institutie,
        @WebParam(name = "dataStart", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataStart,
        @WebParam(name = "dataStop", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataStop,
        @WebParam(name = "dataUltimaModificareStart", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataUltimaModificareStart,
        @WebParam(name = "dataUltimaModificareStop", targetNamespace = "portalquery.just.ro")
        javax.xml.datatype.XMLGregorianCalendar dataUltimaModificareStop
    );
}
