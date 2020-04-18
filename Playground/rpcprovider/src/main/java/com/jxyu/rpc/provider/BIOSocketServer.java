package com.jxyu.rpc.provider;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOSocketServer {
    public static void startServer(int port) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket s=ss.accept();
                es.submit(new RPCrequestHandler(s));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
