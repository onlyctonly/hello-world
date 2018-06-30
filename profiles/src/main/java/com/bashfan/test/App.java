package com.bashfan.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("classes/env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("app.version"));

    }
}
