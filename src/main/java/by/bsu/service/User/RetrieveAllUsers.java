package by.bsu.service.User;

import by.bsu.DAO.impl.UserDAOImpl;
import by.bsu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mikhail on 10.12.2017.
 */
@Service
public class RetrieveAllUsers {
    @Autowired
    UserDAOImpl userDAO;

    public List<User> execute(){
        return userDAO.listUsers();
    }
}
