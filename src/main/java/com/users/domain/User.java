package com.users.domain;

public class User {

    public int id;
    public String firstName;
    public String lastName;
    public Character userRole;
    public User() {

    }

    //constructor
    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Character getUserRole() {
        return userRole;
    }

    public void setUserRole(Character userRole) {
        this.userRole = userRole;
    }
}