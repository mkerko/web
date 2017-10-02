package com.epam.jaxws.dao.impl;

import com.epam.jaxws.dao.DAOHelper;
import com.epam.jaxws.dao.TicketDAO;
import com.epam.jaxws.dao.mapper.TicketMapper;
import com.epam.jaxws.domain.Ticket;
import com.epam.jaxws.exceptions.DAOException;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Mikhail_Kiarko on 1/26/2017.
 */

public class SQLTicketDAO implements TicketDAO {
    static Logger log = Logger.getRootLogger();
    private final static String CREATE_TICKET_SQL = "INSERT INTO TICKETS (DEP_CITY, ARR_CITY, DEP_TIME, ARR_TIME, PRICE, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
    private final static String READ_TICKET_SQL = "SELECT * FROM TICKETS WHERE TICKET_ID = ?";
    private final static String DELETE_TICKET_SQL = "DELETE FROM TICKETS WHERE TICKET_ID = ?";
    private final static String BOOK_TICKET_SQL = "UPDATE TICKETS SET TICKET_STATUS = 2 WHERE TICKET_ID = ?";
    private final static String BUY_TICKET_SQL = "UPDATE TICKETS SET TICKET_STATUS = 3 WHERE TICKET_ID = ?";

    private JdbcTemplate jdbcTemplate;
    private DAOHelper daoHelper;


    public boolean createTicket(Ticket ticket) throws DAOException {
        try {
            jdbcTemplate.update( CREATE_TICKET_SQL, ticket.getDepartureCity(), ticket.getArrivalCity(), ticket.getDepartureTime(), ticket.getArrivalTime(),
                    ticket.getDepartureTime(), ticket.getPrice(), ticket.getStatus());
            log.info("Ticket was created.");
        } catch (DataAccessException e){
            log.warn("Can't create ticket.");
            throw new DAOException(e);
        }
        return true;
    }


    public Ticket readTicket(int ticketID) throws DAOException {
        Ticket ticket;
        try {
            ticket = (Ticket) jdbcTemplate.queryForObject( READ_TICKET_SQL, new TicketMapper(), ticketID);
            log.info("This ticket exists.");
        } catch (DataAccessException e){
            log.warn("Can't get ticket by id.");
            throw new DAOException(e);
        }
        return ticket;
    }


    public void deleteTicket(int ticketID) throws DAOException {
        daoHelper.executeSQL( DELETE_TICKET_SQL, ticketID);
    }


    public void bookTicket(int ticketID) throws DAOException {
        daoHelper.executeSQL( BOOK_TICKET_SQL, ticketID);
    }


    public void buyTicket(int ticketID) throws DAOException {
        daoHelper.executeSQL( BUY_TICKET_SQL, ticketID);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setDaoHelper(DAOHelper daoHelper) {
        this.daoHelper = daoHelper;
    }

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }
}
