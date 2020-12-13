package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Objects;

public class CartPosition implements Serializable {
    Pizza pizza;
    PizzaSize size;
    int numOfPizzas;

    public CartPosition() {
    }

    public CartPosition(Pizza pizza, PizzaSize size, int numOfPizzas) {
        this.pizza = pizza;
        this.size = size;
        this.numOfPizzas = numOfPizzas;
    }

    public CartPosition(Pizza pizza, PizzaSize size) {
        this.pizza = pizza;
        this.size = size;
        numOfPizzas=1;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void incNumOfPizzas() {
        numOfPizzas++;
    }

    public void decNumOfPizzas() {
        numOfPizzas--;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public int getNumOfPizzas() {
        return numOfPizzas;
    }

    public void setNumOfPizzas(int numOfPizzas) {
        this.numOfPizzas = numOfPizzas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartPosition that = (CartPosition) o;
        return numOfPizzas == that.numOfPizzas &&
                pizza.equals(that.pizza) &&
                size.equals(that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza, size, numOfPizzas);
    }

    @Override
    public String toString() {
        return "CartPosition{" +
                "pizza=" + pizza +
                ", size=" + size +
                ", numOfPizzas=" + numOfPizzas +
                '}';
    }
}
