package com.finalproject.group11.model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * login()
     * */
    public void login(){}

    /**
     * logout()
     * */
    public void logout(){}


    public String getPassword(){return this.password;}
    public String getUsername(){return this.name;}


}
