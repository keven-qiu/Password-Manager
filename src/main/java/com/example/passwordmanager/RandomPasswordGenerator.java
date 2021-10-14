package com.example.passwordmanager;

public class RandomPasswordGenerator {
    private String password;
    private int length;
    public static String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTYVWXYZ0123456789";
    public static String specialCharacters = "(,._-*~\\\"<>/|!@#$%^&)+='";

    public RandomPasswordGenerator(int length) {
        password = "";
        this.length = length;
    }
}
