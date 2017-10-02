/**
 * TicketService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.jaxws.client;

public interface TicketService extends java.rmi.Remote {
    public Ticket getTicket(int arg0) throws java.rmi.RemoteException, DaoExceptionFault;
    public void payForTicket(int arg0) throws java.rmi.RemoteException, DaoExceptionFault;
    public void bookTicket(int arg0) throws java.rmi.RemoteException, DaoExceptionFault;
    public void deleteTicket(int arg0) throws java.rmi.RemoteException, DaoExceptionFault;
}
