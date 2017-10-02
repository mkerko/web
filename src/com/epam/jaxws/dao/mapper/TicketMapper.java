package com.epam.jaxws.dao.mapper;

import com.epam.jaxws.domain.Ticket;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.jaxws.util.ClassHelper.*;

/**
 * Created by Mikhail_Kiarko on 1/26/2017.
 */
public class TicketMapper implements RowMapper{

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setID(rs.getInt(TICKET_ID));
        ticket.setDepartureCity(rs.getInt(DEP_CITY));
        ticket.setArrivalCity(rs.getInt(ARR_CITY));
        ticket.setDepartureTime(rs.getInt(DEP_TIME));
        ticket.setArrivalTime(rs.getInt(ARR_TIME));
        ticket.setPrice(rs.getInt(PRICE));
        ticket.setStatus(rs.getInt(TICKET_STATUS));
        ticket.setPassenger(rs.getInt(PASSENGER));
        return ticket;
    }
}
