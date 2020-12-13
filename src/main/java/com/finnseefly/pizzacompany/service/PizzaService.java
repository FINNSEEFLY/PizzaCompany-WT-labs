package com.finnseefly.pizzacompany.service;

import com.finnseefly.pizzacompany.entity.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getAllPizzas() throws ServiceException;
}
