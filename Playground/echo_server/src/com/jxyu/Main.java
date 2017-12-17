package com.jxyu;

import com.sun.security.ntlm.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Echoer echoer = new Echoer(serverSocket.accept());
                echoer.start();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
