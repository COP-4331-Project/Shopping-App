package com.finalproject.group11.view;

import com.finalproject.group11.model.Cart;
import com.finalproject.group11.model.Customer;
//import com.finalproject.group11.users.Placeholder;
import com.finalproject.group11.model.Seller;
import com.finalproject.group11.users.UserDB;
import com.finalproject.group11.users.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterView extends JPanel {

    private static JTextField nameTextField;
    private static JPasswordField passwordField;
    private static JRadioButton customerRole;
    private static JRadioButton sellerRole;
    public static JButton confirm;

    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel customerRoleLabel;
    private JLabel sellerRoleLabel;
    private ButtonGroup g;
    private static JOptionPane confirmationPane;


    public RegisterView()
    {

        this.nameLabel = new JLabel("Username ", JLabel.TRAILING);
        this.nameTextField = new JTextField(20);
        nameLabel.setLabelFor(nameTextField);

        this.passwordLabel = new JLabel("Password", JLabel.TRAILING);
        this.passwordField = new JPasswordField(20);
        passwordLabel.setLabelFor(passwordField);

        this.customerRoleLabel = new JLabel("Customer ", JLabel.TRAILING);
        this.customerRole = new JRadioButton();
        customerRoleLabel.setLabelFor(customerRole);

        this.sellerRoleLabel = new JLabel("Seller ", JLabel.TRAILING);
        this.sellerRole = new JRadioButton();
        sellerRoleLabel.setLabelFor(sellerRole);

        this.confirm = new JButton("Confirm");

        // add JRadioButtons to group to make only one button selectable
        g = new ButtonGroup();
        g.add(customerRole);
        g.add(sellerRole);

        this.add(nameLabel);
        this.add(nameTextField);

        this.add(passwordLabel);
        this.add(passwordField);

        this.add(customerRoleLabel);
        this.add(customerRole);

        this.add(sellerRoleLabel);
        this.add(sellerRole);

        this.add(confirm);


        // actionListener for confirm button
        this.confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    UserDB users = new UserDB();
                    System.out.println(users);


                    if(customerRole.isSelected())
                    {
                        System.out.println("New user is customer");
                        String username = nameTextField.getText();
                        char[] password_char = passwordField.getPassword();
                        String password = new String(password_char);

                        Customer c = new Customer(users.getCustomers().size() + 1, username, password, new Cart(), 100.00);
                        users.addCustomer(c);
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "User created!");
                        users.printCustomers();

                    }
                    else if(sellerRole.isSelected())
                    {
                        System.out.println("New user is seller");
                        String username = nameTextField.getText();
                        char[] password_char = passwordField.getPassword();
                        String password = new String(password_char);

                        //Seller s = new Seller();

                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }


    public static void setUpGui()
    {
        JFrame frame = new JFrame("Register");
        frame.setBackground(new Color(160, 4, 55));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel r = new RegisterView();
        frame.getContentPane().add(r);
        r.setPreferredSize(new Dimension(375, 400));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

}
