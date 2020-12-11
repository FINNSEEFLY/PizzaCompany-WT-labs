package com.finnseefly.pizzacompany.controller;

import com.finnseefly.pizzacompany.controller.command.Command;
import com.finnseefly.pizzacompany.controller.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private final CommandFactory commandFactory = new CommandFactory();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("lang") == null) {
            session.setAttribute("lang", "ru");
        } else {
            String lang = request.getParameter("lang");
            if (lang != null) session.setAttribute("lang", lang);
        }
        if (session.getAttribute("isLoggedIn") == null) {
            session.setAttribute("isLoggedIn", "false");
        }
        String commandName = request.getParameter(commandFactory.PARAMETER_COMMAND);
        Command command = commandFactory.getCommand(commandName);
        if (command == null) {
            command = commandFactory.getCommand(commandFactory.goToMainCommand);
        }
        command.execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
