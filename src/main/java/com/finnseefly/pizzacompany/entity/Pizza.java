package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pizza implements Serializable {
    private static final long serialVersionUID = 8925029464127710599L;

    private long id;
    private String title;
    private String titleRu;
    private List<PizzaSize> sizes = new ArrayList<>();
    private String imagePath;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Pizza() {
    }

    public Pizza(long id, String title, String titleRu, String imagePath) {
        this.id = id;
        this.title = title;
        this.titleRu = titleRu;
        this.imagePath = imagePath;
    }


    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public void addPizzaSize(PizzaSize pizzaSize) {
        sizes.add(pizzaSize);
    }

    public List<PizzaSize> getSizes() {
        return sizes;
    }

    public void setSizes(List<PizzaSize> sizes) {
        this.sizes = sizes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id &&
                title.equals(pizza.title) &&
                titleRu.equals(pizza.titleRu) &&
                sizes.equals(pizza.sizes) &&
                imagePath.equals(pizza.imagePath) &&
                ingredients.equals(pizza.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, titleRu, sizes, imagePath, ingredients);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titleRu='" + titleRu + '\'' +
                ", sizes=" + sizes +
                ", imagePath='" + imagePath + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }


}
