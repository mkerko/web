/**
 * TicketServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.jaxws.client;

public class TicketServiceImplServiceLocator extends org.apache.axis.client.Service implements TicketServiceImplService {

    public TicketServiceImplServiceLocator() {
    }


    public TicketServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TicketServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TicketServiceImplPort
    private java.lang.String TicketServiceImplPort_address = "http://localhost:8087/ticket";

    public java.lang.String getTicketServiceImplPortAddress() {
        return TicketServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TicketServiceImplPortWSDDServiceName = "TicketServiceImplPort";

    public java.lang.String getTicketServiceImplPortWSDDServiceName() {
        return TicketServiceImplPortWSDDServiceName;
    }

    public void setTicketServiceImplPortWSDDServiceName(java.lang.String name) {
        TicketServiceImplPortWSDDServiceName = name;
    }

    public TicketService getTicketServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TicketServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTicketServiceImplPort(endpoint);
    }

    public TicketService getTicketServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TicketServiceImplPortBindingStub _stub = new TicketServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getTicketServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTicketServiceImplPortEndpointAddress(java.lang.String address) {
        TicketServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (TicketService.class.isAssignableFrom(serviceEndpointInterface)) {
                TicketServiceImplPortBindingStub _stub = new TicketServiceImplPortBindingStub(new java.net.URL(TicketServiceImplPort_address), this);
                _stub.setPortName(getTicketServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TicketServiceImplPort".equals(inputPortName)) {
            return getTicketServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.jaxws.epam.com/", "TicketServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.jaxws.epam.com/", "TicketServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TicketServiceImplPort".equals(portName)) {
            setTicketServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
