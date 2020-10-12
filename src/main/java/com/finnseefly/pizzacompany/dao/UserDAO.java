package com.finnseefly.pizzacompany.dao;

import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;

public interface UserDAO {
    User authentication(String login, String password) throws DAOException;

    boolean registration(UserData userData) throws DAOException;
}
