package com.finnseefly.pizzacompany.dao.impl;

import com.finnseefly.pizzacompany.dao.DAOException;
import com.finnseefly.pizzacompany.dao.UserDAO;
import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;

import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {

    @Override
    public User authentication(String login, String password) throws DAOException {
        try {
            //TODO authentication SQL
            throw new SQLException(); //placeholder
        }catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean registration(UserData userData) throws DAOException {
        try {
            //TODO registration SQL
            throw new SQLException(); //placeholder
        }catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
