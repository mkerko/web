package by.bsu.service;

import by.bsu.domain.DTO.UpdatePasswordDTO;
import by.bsu.domain.User;
import by.bsu.service.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mikhail on 10.12.2017.
 */
@Component
public class ServiceFacade {

    @Autowired
    private RetrieveUer retrieveUer;
    @Autowired
    private RetrieveAllUsers retrieveAllUsers;
    @Autowired
    private CreateUser createUser;
    @Autowired
    private DeleteUser deleteUser;
    @Autowired
    private UpdateUser updateUser;
    @Autowired
    private UpdatePassword updatePassword;

    public User retrieveUser(String login){
        return retrieveUer.execute(login);
    }

    public List<User> listUsers(){
        return retrieveAllUsers.execute();
    }

    public void createUser(User user){
        createUser.execute(user);
    }

    public void deleteUser(int id){
        deleteUser.execute(id);
    }

    public void updateUser(User user){
        updateUser.execute(user);
    }

    public void updatePassword(UpdatePasswordDTO dto){
        updatePassword.execute(dto);
    }
}
