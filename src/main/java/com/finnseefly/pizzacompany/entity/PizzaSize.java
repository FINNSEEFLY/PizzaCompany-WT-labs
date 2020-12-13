package com.finnseefly.pizzacompany.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Objects;

public class PizzaSize implements Serializable {
    private int id;
    private int price;
    private int diameterCm;

    public PizzaSize(int id, int price, int diameterCm) {
        this.id = id;
        this.price = price;
        this.diameterCm = diameterCm;
    }

    public PizzaSize() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiameterCm() {
        return diameterCm;
    }

    public void setDiameterCm(int diameterCm) {
        this.diameterCm = diameterCm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaSize pizzaSize = (PizzaSize) o;
        return id == pizzaSize.id &&
                price == pizzaSize.price &&
                diameterCm == pizzaSize.diameterCm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, diameterCm);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "PizzaSize{" +
                    "id=" + id +
                    ", price=" + price +
                    ", diameterCm=" + diameterCm +
                    '}';
        }
    }
}
