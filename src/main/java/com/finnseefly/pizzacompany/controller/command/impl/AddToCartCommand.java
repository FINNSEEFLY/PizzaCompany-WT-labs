package com.finnseefly.pizzacompany.controller.command.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finnseefly.pizzacompany.controller.LinkPath;
import com.finnseefly.pizzacompany.controller.command.Command;
import com.finnseefly.pizzacompany.entity.Cart;
import com.finnseefly.pizzacompany.entity.CartPosition;
import com.finnseefly.pizzacompany.entity.Pizza;
import com.finnseefly.pizzacompany.entity.PizzaSize;

import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToCartCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Cart cart = (Cart)httpSession.getAttribute("cart");
        if (cart==null) {
            httpSession.setAttribute("cart",new Cart());
            cart = new Cart();
        }
        String requestPizza = request.getParameter("pizza");
        String requestSize = request.getParameter("size");
        ObjectMapper objectMapper = new ObjectMapper();
        Pizza pizza = objectMapper.readValue(requestPizza,Pizza.class);
        PizzaSize size = objectMapper.readValue(requestSize,PizzaSize.class);
        if (pizza!=null && size!=null) {
            cart.addPosition(new CartPosition(pizza,size));
        }
        httpSession.setAttribute("cart",cart);
        response.sendRedirect("controller?command=go_to_main");
    }
}
