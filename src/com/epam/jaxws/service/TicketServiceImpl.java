package com.epam.jaxws.service;

import com.epam.jaxws.dao.impl.SQLTicketDAO;
import com.epam.jaxws.domain.Ticket;
import com.epam.jaxws.exceptions.DAOException;
import com.epam.jaxws.factory.DAOFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

/**
 * Created by Mikhail_Kiarko on 2/2/2017.
 */
@WebService(endpointInterface = "com.epam.jaxws.service.TicketService")
public class TicketServiceImpl implements TicketService{
    private SQLTicketDAO sqlTicketDAO = DAOFactory.getTicketDAO();

    @WebMethod
    @GET
    public Ticket getTicket(int id) {
        try {
            return sqlTicketDAO.readTicket(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @WebMethod
    public void bookTicket(int id) throws DAOException {
        try {
            sqlTicketDAO.bookTicket(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @WebMethod
    public void payForTicket(int id) {
        try {
            sqlTicketDAO.buyTicket(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    @DELETE
    public void deleteTicket(int id){
        try {
            sqlTicketDAO.deleteTicket(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    @WebMethod
    public void buyTicket(int id){
        try {
            sqlTicketDAO.buyTicket(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

}
