package com.finnseefly.pizzacompany.dao.impl;

import com.finnseefly.pizzacompany.dao.ConnectionPoolException;
import com.finnseefly.pizzacompany.dao.DAOException;
import com.finnseefly.pizzacompany.dao.UserDAO;
import com.finnseefly.pizzacompany.entity.User;
import com.finnseefly.pizzacompany.entity.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyPermission;

public class SQLUserDAO implements UserDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_ADD_NEW_USER = "INSERT user (login, firstname, lastname, email, pass_and_salt_hash, role_id, salt) VALUES (?, ?, ?, ?, ?, '1', ?)";
    private static final String SQL_GET_USER = "SELECT * FROM user WHERE user.login = ?";

    @Override
    public UserData getUser(String login) throws DAOException {
        try (Connection connection = connectionPool.takeConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER)) {
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    return null;
                }
                UserData user = new UserData();
                user.setSalt(resultSet.getString("salt"));
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("pass_and_salt_hash"));
                user.setRoleId(Integer.parseInt(resultSet.getString("role_id")));
                connectionPool.returnConnection(connection);
                return user;
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean registration(UserData userData, String hashedPass) throws DAOException {
        try (Connection connection = connectionPool.takeConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_NEW_USER)) {
                preparedStatement.setString(1, userData.getLogin());
                preparedStatement.setString(2, userData.getFirstname());
                preparedStatement.setString(3, userData.getLastname());
                preparedStatement.setString(4, userData.getEmail());
                preparedStatement.setString(5, hashedPass);
                preparedStatement.setString(6, userData.getSalt());
                int rows = preparedStatement.executeUpdate();
                connectionPool.returnConnection(connection);
                return rows != 0;
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        }
    }
}
