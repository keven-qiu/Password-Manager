package com.example.passwordmanager;

import java.util.Random;

public class RandomPasswordGenerator {
    private String password;
    private int length;
    private String characters;
    private boolean lowerAlpha;
    private boolean upperAlpha;
    private boolean numeric;
    private boolean special;
    private final Random random;

    public static String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
    public static String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String numbers = "0123456789";
    public static String specialCharacters = "(,._-*~\\\"<>/|!@#$%^&)+='";

    public RandomPasswordGenerator() {
        assignMemberVariables(0, false, false, false, false);
        this.random = new Random();
    }

    private String createAvailableCharacters() {
        String charactersAllowed = "";
        if (lowerAlpha) charactersAllowed += lowerCaseCharacters;
        if (upperAlpha) charactersAllowed += upperCaseCharacters;
        if (numeric) charactersAllowed += numbers;
        if (special) charactersAllowed += specialCharacters;
        return charactersAllowed;
    }

    private void createRandomPassword() {
        StringBuilder stringBuilder = new StringBuilder(password);
        for (int i = 0; i < length; ++i)
            stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
        password = stringBuilder.toString();
    }

    public String getPassword(int len, boolean lower,
        boolean upper, boolean number, boolean spec) {
        assignMemberVariables(len, lower, upper, number, spec);
        createRandomPassword();
        return password;
    }

    private void assignMemberVariables(int len, boolean lower,
        boolean upper, boolean number, boolean spec) {
        this.password = "";
        this.length = len;
        this.lowerAlpha = lower;
        this.upperAlpha = upper;
        this.numeric = number;
        this.special = spec;
        this.characters = createAvailableCharacters();
    }
}
