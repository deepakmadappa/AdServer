/**
 * ServerImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cse535.AdvertizeServer;

public class ServerImplServiceLocator extends org.apache.axis.client.Service implements com.cse535.AdvertizeServer.ServerImplService {

    public ServerImplServiceLocator() {
    }


    public ServerImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServerImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServerImplPort
    private java.lang.String ServerImplPort_address = "http://localhost:9999/ws/hello";

    public java.lang.String getServerImplPortAddress() {
        return ServerImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServerImplPortWSDDServiceName = "ServerImplPort";

    public java.lang.String getServerImplPortWSDDServiceName() {
        return ServerImplPortWSDDServiceName;
    }

    public void setServerImplPortWSDDServiceName(java.lang.String name) {
        ServerImplPortWSDDServiceName = name;
    }

    public com.cse535.AdvertizeServer.Server getServerImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServerImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServerImplPort(endpoint);
    }

    public com.cse535.AdvertizeServer.Server getServerImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cse535.AdvertizeServer.ServerImplPortBindingStub _stub = new com.cse535.AdvertizeServer.ServerImplPortBindingStub(portAddress, this);
            _stub.setPortName(getServerImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServerImplPortEndpointAddress(java.lang.String address) {
        ServerImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cse535.AdvertizeServer.Server.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cse535.AdvertizeServer.ServerImplPortBindingStub _stub = new com.cse535.AdvertizeServer.ServerImplPortBindingStub(new java.net.URL(ServerImplPort_address), this);
                _stub.setPortName(getServerImplPortWSDDServiceName());
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
        if ("ServerImplPort".equals(inputPortName)) {
            return getServerImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://AdvertizeServer.cse535.com/", "ServerImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://AdvertizeServer.cse535.com/", "ServerImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServerImplPort".equals(portName)) {
            setServerImplPortEndpointAddress(address);
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
