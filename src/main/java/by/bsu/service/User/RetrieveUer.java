package by.bsu.service.User;

import by.bsu.DAO.impl.UserDAOImpl;
import by.bsu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mikhail on 10.12.2017.
 */
@Service
public class RetrieveUer {

    @Autowired
    UserDAOImpl userDAO;

    public User execute(String login){
        return userDAO.retrieveUser(login);
    }
}
