package com.cybulskij.Dao;

/**
 * Created with IntelliJ IDEA.
 * User: NAZAR
 * Date: 03/11/13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private  String lastName;
    private String firstName;

    public User(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
