package com.finnseefly.pizzacompany.dao.impl;

import com.finnseefly.pizzacompany.dao.ConnectionPoolException;
import com.finnseefly.pizzacompany.dao.DAOException;
import com.finnseefly.pizzacompany.dao.PizzaDAO;
import com.finnseefly.pizzacompany.entity.Ingredient;
import com.finnseefly.pizzacompany.entity.Pizza;
import com.finnseefly.pizzacompany.entity.PizzaSize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPizzaDAO implements PizzaDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SQL_GET_PIZZAS = "SELECT * FROM pizza";
    private static final String SQL_GET_INGREDIENTS_BY_PIZZA_ID = "SELECT i.id, i.name_ru, i.name FROM ingredient AS i,(SELECT ingredient_id FROM ingredient_pizza WHERE pizza_id = ?) AS ipii WHERE i.id = ipii.ingredient_id";
    private static final String SQL_GET_PRICE_AND_SIZES_BY_PIZZA_ID = "SELECT p.id, p.diameter_cm, price, sppsi.id FROM pizza_size AS p, (SELECT size_id, id, price FROM size_pizza_price AS spp WHERE pizza_id = ?) AS sppsi WHERE p.id = sppsi.size_id";

    @Override
    public List<Pizza> getAllPizzas() throws DAOException {
        List<Pizza> pizzas = new ArrayList<>();
        try {
            Connection connection = connectionPool.takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PIZZAS)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) return null;
                do {
                    pizzas.add(new Pizza(Long.parseLong(resultSet.getString("id")),
                            resultSet.getString("name"),
                            resultSet.getString("name_ru"),
                            resultSet.getString("image_path")));
                } while (resultSet.next());
                connectionPool.returnConnection(connection);
                return pizzas;
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Pizza> getIngredientsForPizzas(List<Pizza> pizzas) throws DAOException {
        try {
            Connection connection = connectionPool.takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_INGREDIENTS_BY_PIZZA_ID)) {
                for (Pizza pizza : pizzas) {
                    String id = String.valueOf(pizza.getId());
                    preparedStatement.setString(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) return null;
                    do {
                        pizza.addIngredient(new Ingredient(Integer.parseInt(resultSet.getString("id")),
                                resultSet.getString("name"),
                                resultSet.getString("name_ru")));
                    } while (resultSet.next());
                }
                connectionPool.returnConnection(connection);
                return pizzas;
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Pizza> getSizesForPizzas(List<Pizza> pizzas) throws DAOException {
        try {
            Connection connection = connectionPool.takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PRICE_AND_SIZES_BY_PIZZA_ID)) {
                for (Pizza pizza : pizzas) {
                    preparedStatement.setString(1, String.valueOf(pizza.getId()));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) return null;
                    do {
                        pizza.addPizzaSize(new PizzaSize(Integer.parseInt(resultSet.getString("id")),
                                Integer.parseInt(resultSet.getString("price")),
                                Integer.parseInt(resultSet.getString("diameter_cm")),
                                Integer.parseInt(resultSet.getString("sppsi.id"))));
                    } while (resultSet.next());
                }
                connectionPool.returnConnection(connection);
                return pizzas;
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }
}
