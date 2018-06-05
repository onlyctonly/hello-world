package com.bashfan.semafore;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private Semaphore semaphore = new Semaphore(10,true);
    private int connections = 0;

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            doConnect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public void doConnect() throws InterruptedException {
        synchronized (this) {
            connections++;
            System.out.println(connections);
        }

        Thread.sleep(2000);

        synchronized (this) {
            connections--;
            System.out.println(connections);
        }
    }
}
