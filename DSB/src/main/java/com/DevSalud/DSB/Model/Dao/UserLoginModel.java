package com.DevSalud.DSB.Model.Dao;

public class UserLoginModel {
    private String User;
    private String Password;

    public UserLoginModel() {
    }

    public UserLoginModel(String user, String password) {
        User = user;
        Password = password;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}