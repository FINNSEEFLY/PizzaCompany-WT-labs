package com.finnseefly.pizzacompany.controller.command.impl;

import com.finnseefly.pizzacompany.controller.LinkPath;
import com.finnseefly.pizzacompany.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLoggedIn","false");
        RequestDispatcher dispatcher = request.getRequestDispatcher(LinkPath.MAIN_PAGE);
        dispatcher.forward(request, response);
    }
}
