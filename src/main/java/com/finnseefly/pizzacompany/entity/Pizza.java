package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Objects;

public class Pizza implements Serializable {
    private static final int PIZZA_SIZE_SMALL = 25;
    private static final int PIZZA_SIZE_MEDIUM = 30;
    private static final int PIZZA_SIZE_BIG = 35;
    private static final long serialVersionUID = 8925029464127710599L;

    private long id;
    private String title;
    private long price;
    private int size;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id &&
                price == pizza.price &&
                size == pizza.size &&
                title.equals(pizza.title);
    }

    @Override
    public int hashCode() {
        final int prime = 97;
        int result = 1;
        result = prime * result + (int) (price ^ (price >>> 32));
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + size;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
