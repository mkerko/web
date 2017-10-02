package com.epam.jaxws.dao.mapper;

import com.epam.jaxws.domain.User;
import com.epam.jaxws.util.ClassHelper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mikhail_Kiarko on 12/26/2016.
 */
public class UserMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setID(rs.getInt(ClassHelper.USER_ID));
        user.setName(rs.getString(ClassHelper.NAME));
        user.setSurname(rs.getString(ClassHelper.SURNAME));
        user.setPatronymic(rs.getString(ClassHelper.PATRONYMIC));
        return user;
    }
}
