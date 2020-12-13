package com.finnseefly.pizzacompany.service;

import com.finnseefly.pizzacompany.service.impl.ClientServiceImpl;
import com.finnseefly.pizzacompany.service.impl.PizzaServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();

    private final PizzaService pizzaService = new PizzaServiceImpl();

    public ClientService getClientService() {
        return clientService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public PizzaService getPizzaService() {
        return pizzaService;
    }
}
