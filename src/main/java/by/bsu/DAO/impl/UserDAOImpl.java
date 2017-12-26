package by.bsu.DAO.impl;

import by.bsu.DAO.UserDAO;
import by.bsu.DAO.mappers.UserMapper;
import by.bsu.domain.DTO.UpdatePasswordDTO;
import by.bsu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikhail on 06.12.2017.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private static final String RETRIEVE_USER_SQL = "select * from USERS where u_email = ?";
    private static final String RETRIEVE_ALL_USERS_SQL = "select * from USERS";
    private static final String DELETE_USER_SQL = "delete from USERS where u_id = ?";
    private static final String UPDATER_PASSWORD_SQL = "update USERS set U_PASSWORD = ? where u_id = ? and U_PASSWORD = ?";
    private static final String UPDATE_USER_SQL = "update USERS set U_EMAIL = ?, U_PASSWORD = ?, U_NAME = ?, U_SURNAME = ?, U_FACULTY = ?, U_COURSE = ?, U_GROUP = ? where u_id = ?";
    private static final String CREATE_USER_SQL = "insert into USERS (U_EMAIL, U_PASSWORD, U_NAME, U_SURNAME, U_FACULTY, U_COURSE, U_GROUP) values (?,?,?,?,?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) {
        jdbcTemplate.update(CREATE_USER_SQL, user.getEmail(),user.getPassword(), user.getName(),
                user.getSurname(), user.getFaculty(), user.getCourse(), user.getGroup());
    }

    @Override
    public User retrieveUser(String login) {
        return jdbcTemplate.queryForObject(RETRIEVE_USER_SQL,
                new Object[]{login}, new UserMapper());
    }

    @Override
    public List<User> listUsers() {
        return jdbcTemplate.query(RETRIEVE_ALL_USERS_SQL,new UserMapper());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_USER_SQL, id);
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(UPDATE_USER_SQL, user.getEmail(),user.getPassword(), user.getName(),
                user.getSurname(), user.getFaculty(), user.getCourse(), user.getGroup(), user.getId());
    }

    @Override
    public void updatePassword(UpdatePasswordDTO dto) {
        jdbcTemplate.update(UPDATER_PASSWORD_SQL, dto.getNext(), dto.getId(), dto.getPrevious());
    }

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
