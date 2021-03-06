package com.finnseefly.pizzacompany.controller.command.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class CreateFullURL {
    public static String create(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();

        Enumeration<String> paramNames = request.getParameterNames();

        String paramName;
        String paramValue;

        while (paramNames.hasMoreElements()) {
            paramName = paramNames.nextElement();
            paramValue = request.getParameter(paramName);
            url.append(paramName).append("=").append(paramValue).append("&");
        }

        return request.getRequestURL() + "?" + url;
    }
}

