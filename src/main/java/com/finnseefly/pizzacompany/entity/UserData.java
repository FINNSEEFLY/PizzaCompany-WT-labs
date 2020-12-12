package com.finnseefly.pizzacompany.entity;

import java.io.Serializable;

import java.util.Objects;

public class UserData implements Serializable {

    private static final long serialVersionUID = -4337805810905229435L;

    private long id;
    private String login;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String salt;
    private int roleId;

    public UserData() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id &&
                roleId == userData.roleId &&
                login.equals(userData.login) &&
                Objects.equals(password, userData.password) &&
                email.equals(userData.email) &&
                Objects.equals(firstname, userData.firstname) &&
                Objects.equals(lastname, userData.lastname) &&
                salt.equals(userData.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, firstname, lastname, salt, roleId);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salt='" + salt + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
