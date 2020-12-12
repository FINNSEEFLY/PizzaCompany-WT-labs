package com.finnseefly.pizzacompany.dao.impl;

import com.finnseefly.pizzacompany.dao.ConnectionPoolException;
import com.finnseefly.pizzacompany.dao.SQLConfig;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {
    private static final int POOL_SIZE = 8;
    private BlockingQueue<Connection> connectionBlockingQueue;
    private BlockingQueue<Connection> givenAwayConQueue;

    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private static final ConnectionPool instance = new ConnectionPool();

    private ConnectionPool() {
        driverName = "com.mysql.cj.jdbc.Driver";
        url = SQLConfig.getUrl();
        user = SQLConfig.getUser();
        password = SQLConfig.getPass();

        poolSize = POOL_SIZE;
        try {
            InitPoolData();
        }
        catch (ConnectionPoolException ignored) {

        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public void InitPoolData() throws ConnectionPoolException {
        try {
            Class.forName(driverName).getDeclaredConstructor().newInstance();
            givenAwayConQueue = new ArrayBlockingQueue<>(poolSize);
            connectionBlockingQueue = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(true);
                connectionBlockingQueue.add(connection);
            }

        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Can't find database driver class", e);
        } catch (NoSuchMethodException e) {
            throw new ConnectionPoolException("Database driver constructor not found", e);
        } catch (InstantiationException e) {
            throw new ConnectionPoolException("Can't create new instance of database driver", e);
        } catch (IllegalAccessException e) {
            throw new ConnectionPoolException("Illegal access", e);
        } catch (InvocationTargetException e) {
            throw new ConnectionPoolException("The underlying constructor throws an exception", e);
        }
        catch (SQLException e) {
            throw new ConnectionPoolException("SQL exception in connection pool", e);
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection = null;
        try {
            connection = connectionBlockingQueue.take();
            givenAwayConQueue.add(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to datasource", e);
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        if (givenAwayConQueue.remove(connection)) connectionBlockingQueue.add(connection);
    }

    private void closeConnectionQueue(Queue<Connection> queue) throws SQLException {
        Connection connection;
        while((connection = connectionBlockingQueue.poll()) != null) {
            if (!connection.getAutoCommit())
                connection.commit();
            connection.close();
        }
    }

    public void dispose() throws ConnectionPoolException {
        try {
            closeConnectionQueue(givenAwayConQueue);
            closeConnectionQueue(connectionBlockingQueue);
        }
        catch (SQLException e) {
            throw new ConnectionPoolException("Disposing error");
        }
    }

}
