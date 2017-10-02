package com.epam.jaxws.service;

import com.epam.jaxws.dao.impl.SQLUserDAO;
import com.epam.jaxws.domain.User;
import com.epam.jaxws.exceptions.DAOException;
import com.epam.jaxws.factory.DAOFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.DELETE;

/**
 * Created by Mikhail on 01.10.2017.
 */
@WebService(endpointInterface = "com.epam.jaxws.service.UserService")
public class UserServiceImpl implements UserService {
    private SQLUserDAO sqlUserDAO = DAOFactory.getUserDAO();
    @WebMethod
    public User getUser(int id) {
        User user = null;
        try {
            user = sqlUserDAO.getUser(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return user;
    }
    @WebMethod
    public void changePassword(int id, String password) {
        try {
            sqlUserDAO.changePassword(id, password);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @WebMethod
    public void createUser(User user){
        try {
            sqlUserDAO.createUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    @DELETE
    public void deleteUser(int id) {
        try {
            sqlUserDAO.deleteUser(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
