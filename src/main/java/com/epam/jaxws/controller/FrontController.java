package com.epam.jaxws.controller;
import com.epam.jaxws.client.ticket.Ticket;
import com.epam.jaxws.client.ticket.TicketService;
import com.epam.jaxws.client.ticket.TicketServiceImplServiceLocator;
import com.epam.jaxws.client.user.User;
import com.epam.jaxws.client.user.UserService;
import com.epam.jaxws.client.user.UserServiceImplServiceLocator;
import org.springframework.web.bind.annotation.*;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created by Mikhail on 26.09.2017.
 */

@RestController
public class FrontController {

    @GetMapping(value = "/getTicket", produces = "application/json")
    public Ticket getTicket(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        TicketService a = new TicketServiceImplServiceLocator().getTicketServiceImplPort();
        return a.getTicket(id);
    }

    @PostMapping(value = "/bookTicket")
    public void bookTicket(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        TicketService a = new TicketServiceImplServiceLocator().getTicketServiceImplPort();
        a.bookTicket(id);
    }

    @PostMapping(value = "/buyTicket")
    public void buyTicket(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        TicketService a = new TicketServiceImplServiceLocator().getTicketServiceImplPort();
        a.buyTicket(id);
    }

    @PostMapping(value = "/deleteTicket")
    public void deleteTicket(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        TicketService a = new TicketServiceImplServiceLocator().getTicketServiceImplPort();
        a.deleteTicket(id);
    }

    @PostMapping(value = "/payForTicket")
    public void payForTicket(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        TicketService a = new TicketServiceImplServiceLocator().getTicketServiceImplPort();
        a.payForTicket(id);
    }

    @GetMapping(value = "/getUser", produces = "application/json")
    public User getUser(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        UserService a = new UserServiceImplServiceLocator().getUserServiceImplPort();
        return a.getUser(id);
    }

    @PostMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam(name = "id") int id) throws RemoteException, ServiceException {
        UserService a = new UserServiceImplServiceLocator().getUserServiceImplPort();
        a.deleteUser(id);
    }

    @PostMapping(value = "/createUser")
    public void createUser(@RequestParam(name = "name") String name, @RequestParam(name = "surname") String surname, @RequestParam(name = "patronymic") String patronymic) throws RemoteException, ServiceException {
        UserService a = new UserServiceImplServiceLocator().getUserServiceImplPort();
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPatronymic(patronymic);
        a.createUser(user);
    }

    @PostMapping(value = "/changePassword")
    public void changePassword(@RequestParam(name = "id") int id, @RequestParam(name = "password") String password) throws RemoteException, ServiceException {
        UserService a = new UserServiceImplServiceLocator().getUserServiceImplPort();
        a.changePassword(id, password);
    }
}
