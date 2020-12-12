package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private  static final long serialVersionUID = -7883421665886134255L;

    private long id;
    private String login;
    private String firstname;
    private String lastname;
    private String email;
    private int role;

    public User() {
    }

    public User(long id, String login, String firstname, String lastname, String email, int role) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }

    public User(UserData userData, int roleId) {
        this.id = userData.getId();
        this.login = userData.getLogin();
        this.firstname = userData.getFirstname();
        this.lastname = userData.getLastname();
        this.email = userData.getEmail();
        this.role = roleId;
    }

    public User(UserData userData) {
        this.id = userData.getId();
        this.login = userData.getLogin();
        this.firstname = userData.getFirstname();
        this.lastname = userData.getLastname();
        this.email = userData.getEmail();
        this.role = userData.getRoleId();
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                role == user.role &&
                login.equals(user.login) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, firstname, lastname, email, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
