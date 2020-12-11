package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {
    private int id;
    private String status;
    private Date date;
    private int price;
    private long userId;
    private int transactionId;
    private List<Pizza> pizzas;

    public Order(int id, String status, Date date, int price, long userId, int transactionId, List<Pizza> pizzas) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.price = price;
        this.userId = userId;
        this.transactionId = transactionId;
        this.pizzas = pizzas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                price == order.price &&
                userId == order.userId &&
                transactionId == order.transactionId &&
                status.equals(order.status) &&
                date.equals(order.date) &&
                Objects.equals(pizzas, order.pizzas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, date, price, userId, transactionId, pizzas);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", userId=" + userId +
                ", transactionId=" + transactionId +
                ", pizzas=" + pizzas +
                '}';
    }
}
