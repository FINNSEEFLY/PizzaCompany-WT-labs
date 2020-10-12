package com.finnseefly.pizzacompany.service;

import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;

public interface ClientService {
    User authorization(String login, String password) throws ServiceException;

    boolean registration(UserData user) throws ServiceException;
}
