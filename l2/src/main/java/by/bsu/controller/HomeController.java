package by.bsu.controller;

import by.bsu.domain.DTO.UpdatePasswordDTO;
import by.bsu.domain.User;
import by.bsu.security.SecurityUtils;
import by.bsu.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private ServiceFacade facade;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView getHome(){
        return new ModelAndView("classpath:WEB-INF/jsp/index.jsp");
    }
    @RequestMapping(value="users/{email}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public User retrieveUser(@PathVariable String email)
    {
        return facade.retrieveUser(email);
    }

    @RequestMapping(value="users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<User> retrieveAllUsers(){
        return facade.listUsers();
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        facade.createUser(user);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PATCH, consumes = "application/json;charset=UTF-8")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        user.setId(id);
        facade.updateUser(user);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        facade.deleteUser(id);
    }

    @RequestMapping(value = "user/{id}/password", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    public void updateUserPassword(@RequestBody UpdatePasswordDTO dto, @PathVariable int id){
        dto.setId(id);
        facade.updatePassword(dto);
    }
    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody User getUserAccount() {
        User user = facade.retrieveUser(SecurityUtils.getCurrentLogin());
        user.setPassword(null);
        return user;
    }
}