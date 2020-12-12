package com.finnseefly.pizzacompany.service;

import com.finnseefly.pizzacompany.service.impl.ClientServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();

    public ClientService getClientService() {
        return clientService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
