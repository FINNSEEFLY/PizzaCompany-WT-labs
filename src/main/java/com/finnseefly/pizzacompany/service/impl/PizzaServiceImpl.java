package com.finnseefly.pizzacompany.service.impl;

import com.finnseefly.pizzacompany.dao.DAOException;
import com.finnseefly.pizzacompany.dao.DAOFactory;
import com.finnseefly.pizzacompany.dao.PizzaDAO;
import com.finnseefly.pizzacompany.dao.UserDAO;
import com.finnseefly.pizzacompany.entity.Pizza;
import com.finnseefly.pizzacompany.service.PizzaService;
import com.finnseefly.pizzacompany.service.ServiceException;
import com.finnseefly.pizzacompany.service.ServiceFactory;

import java.util.List;

public class PizzaServiceImpl implements PizzaService {
    @Override
    public List<Pizza> getAllPizzas() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        PizzaDAO pizzaDAO = daoFactory.getPizzaDAO();
        List<Pizza> pizzas = null;
        try {
            pizzas = pizzaDAO.getAllPizzas();
            pizzas = pizzaDAO.getIngredientsForPizzas(pizzas);
            pizzas = pizzaDAO.getSizesForPizzas(pizzas);
            return pizzas;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
