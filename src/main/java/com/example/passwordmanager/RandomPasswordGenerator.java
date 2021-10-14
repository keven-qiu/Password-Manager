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
    /* ASCII VALUES */
    // numbers: 48-57
    // lowercase: 97-122
    // uppercase: 65-90

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
            stringBuilder.append(characters.charAt(random.nextInt(length)));
        password = stringBuilder.toString();
    }

    public String getPassword(int length, boolean lowerAlpha,
        boolean upperAlpha, boolean numeric, boolean special) {
        assignMemberVariables(length, lowerAlpha, upperAlpha, numeric, special);
        createRandomPassword();
        return password;
    }

    private void assignMemberVariables(int length, boolean lowerAlpha,
        boolean upperAlpha, boolean numeric, boolean special) {
        this.password = "";
        this.length = length;
        this.lowerAlpha = lowerAlpha;
        this.upperAlpha = upperAlpha;
        this.numeric = numeric;
        this.special = special;
        this.characters = createAvailableCharacters();
    }
}
