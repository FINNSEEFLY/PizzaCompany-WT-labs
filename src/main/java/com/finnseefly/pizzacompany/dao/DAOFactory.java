package com.finnseefly.pizzacompany.dao;

import com.finnseefly.pizzacompany.dao.impl.SQLPizzaDAO;
import com.finnseefly.pizzacompany.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new SQLUserDAO();

    private final PizzaDAO pizzaDAO = new SQLPizzaDAO();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public PizzaDAO getPizzaDAO() {
        return pizzaDAO;
    }
}
