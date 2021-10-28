package com.example.passwordmanager;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordReaderWriter {
    private static String s;
    private static String email;
    private static String password;

    public static void writeFile(String website, String email,
        String password) {
        try {
            Process p =
                Runtime.getRuntime().exec("python3 jsonwriter.py " + website + " " + email + " " + password);
            BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));

            while ((s = stdError.readLine()) != null) {
                System.err.println(s);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Pair<String, String> readFile(String website) {
        try {
            Process p =
                Runtime.getRuntime().exec("python3 jsonreader.py " + website);
            BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));
            while ((s = stdInput.readLine()) != null) {
                email = s.split(" ")[0];
                password = s.split(" ")[1];
            }
            return new Pair<>(email, password);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return new Pair<>("", "");
    }
}
