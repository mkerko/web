package com.epam.jaxws.dao;


import com.epam.jaxws.domain.User;
import com.epam.jaxws.exceptions.DAOException;

public interface UserDAO {
	User getUser(int id) throws DAOException;
	void deleteUser(int id) throws  DAOException;
	int getUserID(String login, String password) throws DAOException;
	void createUser(User user) throws DAOException;
}
