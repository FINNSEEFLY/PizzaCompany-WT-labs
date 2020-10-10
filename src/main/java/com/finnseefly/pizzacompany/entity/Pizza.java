package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Objects;

public class Pizza implements Serializable {
    private static final int PIZZA_SIZE_SMALL = 25;
    private static final int PIZZA_SIZE_MEDIUM = 30;
    private static final int PIZZA_SIZE_BIG = 35;
    private static final long serialVersionUID = 8925029464127710599L;

    private String title;
    private long price;

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
        return price == pizza.price &&
                title.equals(pizza.title);
    }

    @Override
    public int hashCode() {
        final int prime = 97;
        int result = 1;
        result = prime * result + (int) (price ^ (price >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
