package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Serializable {
    private int id;
    private long bankAccount;
    private Date date;
    private int sum;

    public Transaction(int id, long bankAccount, Date date, int sum) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.date = date;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                bankAccount == that.bankAccount &&
                sum == that.sum &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankAccount, date, sum);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bankAccount=" + bankAccount +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}

