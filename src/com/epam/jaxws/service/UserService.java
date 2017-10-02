package com.epam.jaxws.service;

import com.epam.jaxws.domain.User;
import com.epam.jaxws.exceptions.DAOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Mikhail on 01.10.2017.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

    @WebMethod
    User getUser(int id) throws DAOException;
    @WebMethod
    void changePassword(int id, String password) throws DAOException;
    @WebMethod
    void createUser(User user) throws DAOException;
    @WebMethod
    void deleteUser(int id) throws DAOException;
}
