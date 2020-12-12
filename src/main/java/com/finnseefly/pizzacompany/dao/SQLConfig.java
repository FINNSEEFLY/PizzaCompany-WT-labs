package com.finnseefly.pizzacompany.dao;

public class SQLConfig {
    private static final String url = "jdbc:mysql://localhost/pizzacompanydb?characterEncoding=utf8&allowPublicKeyRetrieval=true&serverTimezone=Europe/Moscow&useSSL=false";
    private static final String user = "root";
    private static final String pass = "1337420";

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPass() {
        return pass;
    }
}

