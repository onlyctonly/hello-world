package com.jxyu.rpc.api;

import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 5691489431799268298L;
    private String userID;
    private String name;
    private String surname;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name+surname+userID;
    }
}
