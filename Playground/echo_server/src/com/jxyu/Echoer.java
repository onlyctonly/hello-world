package com.jxyu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("client connected");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            String echoString;
            while (true) {
                echoString = br.readLine();
                if ((echoString!=null) && echoString.equals("exit")) {
                    break;
                }
                pw.println("server said: " + echoString);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println("client disconnected");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
