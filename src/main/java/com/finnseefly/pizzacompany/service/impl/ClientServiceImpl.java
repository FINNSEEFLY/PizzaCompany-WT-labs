package com.finnseefly.pizzacompany.service.impl;

import com.finnseefly.pizzacompany.controller.command.util.CryptoUtil;
import com.finnseefly.pizzacompany.dao.DAOException;
import com.finnseefly.pizzacompany.dao.DAOFactory;
import com.finnseefly.pizzacompany.dao.UserDAO;
import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;
import com.finnseefly.pizzacompany.service.ClientService;
import com.finnseefly.pizzacompany.service.ServiceException;
import com.finnseefly.pizzacompany.service.validation.BasicValidator;

public class ClientServiceImpl implements ClientService {
    @Override
    public User authorization(String login, String password) throws ServiceException {
        if (!BasicValidator.isUserCorrect(login, password))
            throw new ServiceException("Invalid login or password");
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        UserData userData;
        try {
            userData = userDAO.getUser(login);
            if (userData != null) {
                if (CryptoUtil.getHashedPassword(password, userData.getSalt()).equals(userData.getPassword())) {
                    return new User(userData);
                } else {
                    return null;
                }
            } else return null;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean registration(UserData userData) throws ServiceException {
        if (!BasicValidator.isUserDataCorrect(userData))
            throw new ServiceException("Invalid registration data");
        userData.setSalt(CryptoUtil.getNewSalt());
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        boolean result = false;
        try {
            result = userDAO.registration(userData, CryptoUtil.getHashedPassword(userData.getPassword(), userData.getSalt()));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
