package com.jxyu.rpc.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RPCrequestHandler implements Runnable {
    private Socket s;

    public RPCrequestHandler(Socket s) {
        this.s=s;
    }

    @Override
    public void run() {
        ObjectInputStream ois=null;
        ObjectOutputStream oss =null;
        try {
            oss = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            Object obj= ServiceDispather.dispatch(ois.readObject());
            oss.writeObject(obj);
            oss.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (oss != null) {
                try {
                    oss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
