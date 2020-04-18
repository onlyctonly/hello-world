package com.jxyu.rpc;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BioClient {
    public static Object callRemote(Object o,String host, int port) {
        Socket s = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois =null;
        Object ro=null;
        try {
            s = new Socket(host, port);
            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);
            oos.flush();

            ois = new ObjectInputStream(s.getInputStream());
            ro=ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ro;
    }
}
