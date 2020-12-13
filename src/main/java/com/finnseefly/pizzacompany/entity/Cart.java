package com.finnseefly.pizzacompany.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart implements Serializable {
    List<CartPosition> positions = new ArrayList<>();

    public Cart() {
    }

    public List<CartPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<CartPosition> positions) {
        this.positions = positions;
    }

    public int getFinalSum() {
        int sum = 0;
        for (CartPosition item:positions) {
            sum+=item.size.getPrice()*item.numOfPizzas;
        }
        return sum;
    }

    public void addPosition(CartPosition position) {
        boolean isAlreadyHere = false;
        for (CartPosition item : positions) {
            if (position.pizza.equals(item.pizza) && position.size.equals(item.size)) {
                item.incNumOfPizzas();
                isAlreadyHere = true;
                break;
            }
        }
        if (!isAlreadyHere) {
            positions.add(position);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return positions.equals(cart.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Cart{" +
                    "positions=" + positions +
                    '}';
        }
    }
}
