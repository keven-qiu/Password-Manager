package com.example.passwordmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomPasswordGeneratorTest {
    private RandomPasswordGenerator generator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        generator = new RandomPasswordGenerator();
    }

    @Test
    public void testLowerCasePassword() {
        String password = generator.getPassword(30, true,
            false, false, false);
        String otherCharacters =
            RandomPasswordGenerator.upperCaseCharacters + RandomPasswordGenerator.numbers +
                RandomPasswordGenerator.specialCharacters;
        boolean otherCharactersAppear = false;
        for (int i = 0; i < otherCharacters.length(); ++i) {
            if (password.indexOf(otherCharacters.charAt(i)) != -1) {
                otherCharactersAppear = true;
                break;
            }
        }
        Assertions.assertFalse(otherCharactersAppear);
    }

    @Test
    public void testUpperCasePassword() {
        String password = generator.getPassword(30, false,
            true, false, false);
        String otherCharacters =
            RandomPasswordGenerator.lowerCaseCharacters + RandomPasswordGenerator.numbers +
                RandomPasswordGenerator.specialCharacters;
        boolean otherCharactersAppear = false;
        for (int i = 0; i < otherCharacters.length(); ++i) {
            if (password.indexOf(otherCharacters.charAt(i)) != -1) {
                otherCharactersAppear = true;
                break;
            }
        }
        Assertions.assertFalse(otherCharactersAppear);
    }

    @Test
    public void testNumericPassword() {
        String password = generator.getPassword(30, false,
            false, true, false);
        String otherCharacters =
            RandomPasswordGenerator.lowerCaseCharacters + RandomPasswordGenerator.upperCaseCharacters +
                RandomPasswordGenerator.specialCharacters;
        boolean otherCharactersAppear = false;
        for (int i = 0; i < otherCharacters.length(); ++i) {
            if (password.indexOf(otherCharacters.charAt(i)) != -1) {
                otherCharactersAppear = true;
                break;
            }
        }
        Assertions.assertFalse(otherCharactersAppear);
    }

    @Test
    public void testSpecialPassword() {
        String password = generator.getPassword(30, false,
            false, false, true);
        String otherCharacters =
            RandomPasswordGenerator.lowerCaseCharacters + RandomPasswordGenerator.upperCaseCharacters +
                RandomPasswordGenerator.numbers;
        boolean otherCharactersAppear = false;
        for (int i = 0; i < otherCharacters.length(); ++i) {
            if (password.indexOf(otherCharacters.charAt(i)) != -1) {
                otherCharactersAppear = true;
                break;
            }
        }
        Assertions.assertFalse(otherCharactersAppear);
    }

    @Test
    public void testComboPassword() {
        String password = generator.getPassword(30, true,
            false, true, true);
        String otherCharacters =
            RandomPasswordGenerator.upperCaseCharacters;
        boolean otherCharactersAppear = false;
        for (int i = 0; i < otherCharacters.length(); ++i) {
            if (password.indexOf(otherCharacters.charAt(i)) != -1) {
                otherCharactersAppear = true;
                break;
            }
        }
        Assertions.assertFalse(otherCharactersAppear);
    }
}