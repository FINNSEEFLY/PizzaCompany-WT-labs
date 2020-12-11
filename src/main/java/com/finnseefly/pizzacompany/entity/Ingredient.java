package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Objects;

public class Ingredient implements Serializable {
    private int id;
    private String name;
    private int mass;
    private String description;

    public Ingredient(int id, String name, int mass, String description) {
        this.id = id;
        this.name = name;
        this.mass = mass;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id &&
                mass == that.mass &&
                name.equals(that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mass, description);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mass=" + mass +
                ", description='" + description + '\'' +
                '}';
    }
}
