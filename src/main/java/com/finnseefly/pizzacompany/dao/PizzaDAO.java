package com.finnseefly.pizzacompany.dao;

import com.finnseefly.pizzacompany.entity.Pizza;

import java.util.List;

public interface PizzaDAO {
    List<Pizza> getAllPizzas() throws DAOException;
    List<Pizza> getIngredientsForPizzas(List<Pizza> pizzas) throws DAOException;
    List<Pizza> getSizesForPizzas(List<Pizza> pizzas) throws DAOException;
}
