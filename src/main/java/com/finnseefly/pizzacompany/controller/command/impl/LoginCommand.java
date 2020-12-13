package com.finnseefly.pizzacompany.controller.command.impl;

import com.finnseefly.pizzacompany.controller.LinkPath;
import com.finnseefly.pizzacompany.controller.command.Command;
import com.finnseefly.pizzacompany.entity.Cart;
import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;
import com.finnseefly.pizzacompany.service.ClientService;
import com.finnseefly.pizzacompany.service.ServiceException;
import com.finnseefly.pizzacompany.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isLoggedIn = (String) request.getSession().getAttribute("isLoggedIn");
        if (isLoggedIn.equals("false")) {
            ClientService clientService = ServiceFactory.getInstance().getClientService();
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            User user = null;
            if (login != null && pass != null) {
                try {
                    user = clientService.authorization(login, pass);
                } catch (ServiceException e) {
                    //TODO: to process exception
                }
            }
            if (user != null) {
                request.getSession().setAttribute("isLoggedIn", "true");
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("cart", new Cart());
                response.sendRedirect("controller?command=go_to_main");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(LinkPath.LOGIN_PAGE);
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("controller?command=go_to_main");
        }
    }
}
