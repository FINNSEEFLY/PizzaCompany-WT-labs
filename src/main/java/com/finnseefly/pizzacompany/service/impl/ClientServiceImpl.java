package com.finnseefly.pizzacompany.service.impl;

import com.finnseefly.pizzacompany.dao.DAOException;
import com.finnseefly.pizzacompany.dao.DAOFactory;
import com.finnseefly.pizzacompany.dao.UserDAO;
import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;
import com.finnseefly.pizzacompany.service.ClientService;
import com.finnseefly.pizzacompany.service.ServiceException;
import com.finnseefly.pizzacompany.service.validation.BasicValidator;
import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.constraints.Email;

public class ClientServiceImpl implements ClientService {
    @Override
    public User authorization(String login, String password) throws ServiceException {
        if (!BasicValidator.isUserCorrect(login, password))
            throw new ServiceException("Invalid login or password");
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        User user;
        try {
            user = userDAO.authentication(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public boolean registration(UserData userData) throws ServiceException {
        if (!BasicValidator.isUserDataCorrect(userData))
            throw new ServiceException("Invalid registration data");
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            return userDAO.registration(userData);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
