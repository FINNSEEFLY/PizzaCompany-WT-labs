package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Pizza implements Serializable {
    private static final long serialVersionUID = 8925029464127710599L;

    private long id;
    private String title;
    private long price;
    private int size;
    private String imagePath;
    private List<String> ingredients;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id &&
                price == pizza.price &&
                size == pizza.size &&
                title.equals(pizza.title) &&
                imagePath.equals(pizza.imagePath) &&
                ingredients.equals(pizza.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, size, imagePath, ingredients);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", imagePath='" + imagePath + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
