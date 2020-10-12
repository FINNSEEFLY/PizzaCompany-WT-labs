package com.finnseefly.pizzacompany.service.validation;

import com.finnseefly.pizzacompany.entity.UserData;
import org.apache.commons.validator.routines.EmailValidator;
import org.jsoup.Jsoup;

public class BasicValidator {

    public static boolean isUserCorrect(String login, String password) {
        return isLoginCorrect(login) && isPasswordCorrect(password);
    }

    public static boolean isUserDataCorrect(UserData userData) {
        return isLoginCorrect(userData.getLogin()) && isPasswordCorrect(userData.getPassword()) && isEmailCorrect(userData.getEmail());
    }

    private static boolean isLoginCorrect(String login) {
        login = Jsoup.parse(login).text();
        return (login.trim().length() > 2);
    }

    private static boolean isPasswordCorrect(String password) {
        password = Jsoup.parse(password).text();
        return password.trim().length() > 2;
    }

    private static boolean isEmailCorrect(String email) {
        email = Jsoup.parse(email).text();
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }
}
