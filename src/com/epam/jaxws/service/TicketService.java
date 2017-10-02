package com.epam.jaxws.service;


import com.epam.jaxws.domain.Ticket;
import com.epam.jaxws.exceptions.DAOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Created by Mikhail_Kiarko on 2/2/2017.
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface TicketService {

    @WebMethod
    Ticket getTicket(int id) throws DAOException;
    @WebMethod
    void bookTicket(int id) throws DAOException;
    @WebMethod
    void payForTicket(int id) throws DAOException;
    @WebMethod
    void deleteTicket(int id) throws DAOException;
    @WebMethod
    void buyTicket(int id) throws DAOException;
}
