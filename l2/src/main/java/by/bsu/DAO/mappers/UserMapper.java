package by.bsu.DAO.mappers;

import by.bsu.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mikhail on 06.12.2017.
 */
public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setEmail(rs.getString("u_email"));
        user.setPassword(rs.getString("u_password"));
        user.setName(rs.getString("u_name"));
        user.setSurname(rs.getString("u_surname"));
        user.setFaculty(rs.getString("u_faculty"));
        user.setCourse(rs.getInt("u_course"));
        user.setGroup(rs.getInt("u_group"));
        return user;
    }
}
