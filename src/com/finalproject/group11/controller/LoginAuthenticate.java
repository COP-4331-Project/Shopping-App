package com.finalproject.group11.controller;

public class LoginAuthenticate {
    public static boolean authenticate(String username, char[] password) {
        String p = new String(password);
        // hardcoded username and password
        return username.equals("bob") && p.equals("secret");
    }
}
