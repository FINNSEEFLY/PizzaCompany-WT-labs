package com.finnseefly.pizzacompany.controller.command.impl;

import com.finnseefly.pizzacompany.controller.LinkPath;
import com.finnseefly.pizzacompany.controller.command.Command;
import com.finnseefly.pizzacompany.entity.Pizza;
import com.finnseefly.pizzacompany.service.PizzaService;
import com.finnseefly.pizzacompany.service.ServiceException;
import com.finnseefly.pizzacompany.service.ServiceFactory;
import com.finnseefly.pizzacompany.service.impl.PizzaServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToMainCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        PizzaService pizzaService = new PizzaServiceImpl();
        try {
            List<Pizza> pizzas = pizzaService.getAllPizzas();
        } catch (ServiceException e) {

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(LinkPath.MAIN_PAGE);
        dispatcher.forward(request, response);
    }
}
