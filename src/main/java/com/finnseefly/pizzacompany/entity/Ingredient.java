package com.finnseefly.pizzacompany.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Objects;

public class Ingredient implements Serializable {
    private int id;
    private String name;
    private String nameRu;

    public Ingredient(int id, String name, String nameRu) {
        this.id = id;
        this.name = name;
        this.nameRu = nameRu;
    }

    public Ingredient() {
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


    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id &&
                name.equals(that.name) &&
                nameRu.equals(that.nameRu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nameRu);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Ingredient{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", nameRu='" + nameRu + '\'' +
                    '}';
        }
    }

}
