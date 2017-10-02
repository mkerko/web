package com.epam.jaxws.factory;


import com.epam.jaxws.dao.impl.SQLTicketDAO;
import com.epam.jaxws.dao.impl.SQLUserDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Created by Mikhail_Kiarko on 2/1/2017.
 */
public class DAOFactory {

    private static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    private DAOFactory(){}

    public static SQLTicketDAO getTicketDAO() {
        return context.getBean(SQLTicketDAO.class);

    }

    public static SQLUserDAO getUserDAO() {
        return context.getBean(SQLUserDAO.class);

    }

    public static File getFile(){
        return new File("jaxb.xml");
    }
}
