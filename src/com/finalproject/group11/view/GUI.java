package com.finalproject.group11.view;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Shop App");

        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);


        LoginView loginPanel = new LoginView();
        frame.getContentPane().add(loginPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
