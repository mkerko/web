package com.epam.jaxws.dao.impl;

import com.epam.jaxws.dao.DAOHelper;
import com.epam.jaxws.dao.UserDAO;
import com.epam.jaxws.dao.mapper.UserMapper;
import com.epam.jaxws.domain.User;
import com.epam.jaxws.exceptions.DAOException;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLUserDAO implements UserDAO {

	static Logger log = Logger.getRootLogger();
		private static final String GET_USER_SQL = "SELECT USERS_INFO.USER_ID, NAME, SURNAME, PATRONYMIC, PHONE, EMAIL, PASSPORT_SERIES, PASSPORT_NUMBER, COUNTRY_ID, CITY_ID, ADDRESS, ROLE, LOGIN, PASSWORD from USERS_INFO , USERS where USERS_INFO.USER_ID = ? AND USERS.USER_ID =?";
	private final static String GET_MAX_USER_ID_SQL = "SELECT MAX(USER_ID) FROM USERS_INFO";
	private final static String CREATE_USER = "INSERT INTO USERS_INFO (NAME, SURNAME, PATRONYMIC) VALUES (?, ?, ?)";
	private final static String DELETE_USERS_INFO_SQL = "DELETE FROM USERS_INFO WHERE USER_ID = ?";
	private final static String GET_USER_ID_SQL = "SELECT USER_ID FROM USERS WHERE Login = ? and Password = ?";
	private static final  String UPDATE_PASSWORD = "UPDATE USERS SET PASSWORD = ? WHERE USER_ID = ?";

	private JdbcTemplate jdbcTemplate;
	private DAOHelper daoHelper;


	public User getUser(int userID) throws DAOException {
		User user;
		try {
				user = (User) jdbcTemplate.queryForObject(GET_USER_SQL, new UserMapper(), userID, userID);
				log.info("This user exists.");
		} catch (DataAccessException e){
			log.warn("Can't get user by id.");
			throw new DAOException(e);
		}
		return user;
	}

	public void deleteUser(int userID) throws DAOException {
		daoHelper.executeSQL(DELETE_USERS_INFO_SQL, userID);
	}
	public int getUserID(String login, String password) throws DAOException {
		Integer userID;
		try{
			userID = jdbcTemplate.queryForObject( GET_USER_ID_SQL, Integer.class, login, password);
			if (userID != null) {
				log.info("We have such user.");
				return userID;
			} else {
				log.info("We do not have such user.");
				throw new DAOException("Incorrect password or login");
			}
		} catch (DataAccessException e){
			throw new DAOException("Incorrect password or login", e);
		}
	}

	public void createUser(User user) throws DAOException {
		try {
			jdbcTemplate.update( CREATE_USER, user.getName(), user.getSurname(), user.getPatronymic());
		} catch (DataAccessException e){
			log.warn("Unable to create user entry info.");
			throw new DAOException(e);
		}
	}

	public int getMaxUserID() throws DAOException {
		try {
			return jdbcTemplate.queryForObject(GET_MAX_USER_ID_SQL, int.class);
		} catch (DataAccessException e){
			log.warn("Can't get max userID.");
			throw new DAOException(e);
		}
	}

	public void changePassword(int userID, String newPassword) throws DAOException {
		try {
			jdbcTemplate.update(UPDATE_PASSWORD, newPassword, userID);
		} catch (DataAccessException e){
			log.warn("Can't get max userID.");
			throw new DAOException(e);
		}
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDaoHelper(DAOHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
}
