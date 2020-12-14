package com.finnseefly.pizzacompany.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Objects;

public class PizzaSize implements Serializable {
    private int id;
    private int price;
    private int diameterCm;
    private int sizePizzaPriceId;

    public PizzaSize(int id, int price, int diameterCm) {
        this.id = id;
        this.price = price;
        this.diameterCm = diameterCm;
    }

    public PizzaSize(int id, int price, int diameterCm, int sizePizzaPriceId) {
        this.id = id;
        this.price = price;
        this.diameterCm = diameterCm;
        this.sizePizzaPriceId = sizePizzaPriceId;
    }

    public PizzaSize() {
    }

    public static PizzaSize getPizzaSizeFromJson(String json) {
        try {
            return new ObjectMapper().readValue(json,PizzaSize.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public int getSizePizzaPriceId() {
        return sizePizzaPriceId;
    }

    public void setSizePizzaPriceId(int sizePizzaPriceId) {
        this.sizePizzaPriceId = sizePizzaPriceId;
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
                    ", sizePizzaPriceId=" + sizePizzaPriceId +
                    '}';
        }
    }
}
