package com.epam.jaxws.dao;

import com.epam.jaxws.exceptions.DAOException;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Mikhail_Kiarko on 1/26/2017.
 */
public class DAOHelper {

    private JdbcTemplate jdbcTemplate;

    static Logger log = Logger.getRootLogger();
    public void executeSQL(String query, int ID) throws DAOException {
        try {
            jdbcTemplate.update( query, ID);
            log.info("Entity changed successfully.");
        } catch (DataAccessException e){
            log.warn("Entity query execution failed.");
            throw new DAOException(e);
        }
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
