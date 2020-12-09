/**
 * User class
 * @author Ross Parsons
 * */


package com.finalproject.group11.model;

import java.io.Serializable;

public class User implements Serializable{

    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password){
        this.setId(id);
        this.name = name;
        this.password = password;
    }


    /**
     * getPassword()
     * @return password
     * */
    public String getPassword(){return this.password;}

    /**
     * getUsername()
     * @return username
     * */
    public String getUsername(){return this.name;}


    /**
     * getId()
     * @return id
     * */
	public int getId() {
		return id;
	}


    /**
     * setId()
     * @param id
     * @return void
     * */
	public void setId(int id) {
		this.id = id;
	}

}
