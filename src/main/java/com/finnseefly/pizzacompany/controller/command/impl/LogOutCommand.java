package com.finnseefly.pizzacompany.controller.command.impl;

import com.finnseefly.pizzacompany.controller.LinkPath;
import com.finnseefly.pizzacompany.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("isLoggedIn", "false");
        httpSession.removeAttribute("user");
        response.sendRedirect("controller?command=go_to_main");
    }
}
