package by.bsu.service.User;

import by.bsu.DAO.impl.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mikhail on 10.12.2017.
 */
@Service
public class DeleteUser {

    @Autowired
    UserDAOImpl userDAO;

    public void execute(int id){
        userDAO.delete(id);
    }
}
