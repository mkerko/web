package by.bsu.DAO;

import by.bsu.domain.DTO.UpdatePasswordDTO;
import by.bsu.domain.User;

import java.util.List;

/**
 * Created by Mikhail on 06.12.2017.
 */
public interface UserDAO {

    /**
     * This is the method to be used to create
     * a record in the User table.
     */
    void create(User user);

    /**
     * This is the method to be used to list down
     * a record from the User table corresponding
     * to a passed student id.
     */
    User retrieveUser(String login);

    /**
     * This is the method to be used to list down
     * all the records from the User table.
     */
    List<User> listUsers();

    /**
     * This is the method to be used to delete
     * a record from the User table corresponding
     * to a passed student id.
     */
    void delete(Integer id);

    /**
     * This is the method to be used to update
     * a records into the User table.
     */
    void update(User user);

    /**
     * This is the method to be used to update
     * a password into the User table.
     */
    void updatePassword(UpdatePasswordDTO dto);
}
