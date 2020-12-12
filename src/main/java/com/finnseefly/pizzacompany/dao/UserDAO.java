package com.finnseefly.pizzacompany.dao;

import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;

public interface UserDAO {
    UserData getUser(String login) throws DAOException;

    boolean registration(UserData userData, String hashedPass) throws DAOException;
}
