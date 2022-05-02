package com.connect.hiveconnect.model;

public class User {
    public String name;
    public String email;
    public String number;
    public String password;
    public String gender;

    public User(String name, String email, String number, String password, String gender) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
        this.gender = gender;
    }
}
