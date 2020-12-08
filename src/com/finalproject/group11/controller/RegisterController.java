package com.finalproject.group11.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton customerRole = null;
        AbstractButton sellerRole = null;
        if(customerRole.isSelected())
        {
            System.out.println("New user is customer");

        }
        else if(sellerRole.isSelected())
        {
            System.out.println("New user is seller");
        }
    }
}
