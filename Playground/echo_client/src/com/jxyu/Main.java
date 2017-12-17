package com.jxyu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Socket sk = new Socket("127.0.0.1", 5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            String echoString;
            String response;

            do {
                System.out.println("Enter message to be echoed: ");
                echoString = sc.nextLine();
                pw.println(echoString);

                if (!echoString.equals("exit")) {
                    response = br.readLine();
                    System.out.println(response);
                }

            } while (!echoString.equals("exit"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
