package com.epam.jaxws.dao;

import com.epam.jaxws.domain.Ticket;
import com.epam.jaxws.exceptions.DAOException;

/**
 * Created by Mikhail_Kiarko on 1/26/2017.
 */
public interface TicketDAO {
    boolean createTicket(Ticket ticket) throws DAOException;
    Ticket readTicket(int ticketID) throws DAOException;
    void deleteTicket(int ticketID) throws DAOException;
    void bookTicket(int ticketID) throws DAOException;
    void buyTicket(int ticketID) throws DAOException;
}
