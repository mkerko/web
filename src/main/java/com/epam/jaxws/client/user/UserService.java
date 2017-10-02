/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.jaxws.client.user;

public interface UserService extends java.rmi.Remote {
    public void createUser(com.epam.jaxws.client.user.User arg0) throws java.rmi.RemoteException, com.epam.jaxws.client.user.DaoExceptionFault;
    public void changePassword(int arg0, java.lang.String arg1) throws java.rmi.RemoteException, com.epam.jaxws.client.user.DaoExceptionFault;
    public void deleteUser(int arg0) throws java.rmi.RemoteException, com.epam.jaxws.client.user.DaoExceptionFault;
    public com.epam.jaxws.client.user.User getUser(int arg0) throws java.rmi.RemoteException, com.epam.jaxws.client.user.DaoExceptionFault;
}
