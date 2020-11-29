package com.finalproject.group11.controller;

import com.finalproject.group11.model.User;
import com.finalproject.group11.view.GUI;
import com.finalproject.group11.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private User user;
    private final String username;
    private final String userPassword;


    public UserController(User user) {
        this.user = user;
        this.username = user.getUsername();
        this.userPassword = user.getPassword();
    }

}

