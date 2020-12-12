package com.finnseefly.pizzacompany.controller.command.impl;

import com.finnseefly.pizzacompany.controller.LinkPath;
import com.finnseefly.pizzacompany.controller.command.Command;
import com.finnseefly.pizzacompany.entity.UserData;
import com.finnseefly.pizzacompany.service.ClientService;
import com.finnseefly.pizzacompany.service.ServiceException;
import com.finnseefly.pizzacompany.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        UserData user = new UserData();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        if (login!=null && pass!=null && email!=null) {
            user.setLogin(login);
            user.setEmail(email);
            user.setPassword(pass);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            try {
                clientService.registration(user);
            }catch (ServiceException e) {

            }
        } else {

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(LinkPath.CONTACTS_PAGE);
        dispatcher.forward(request, response);
    }
}
