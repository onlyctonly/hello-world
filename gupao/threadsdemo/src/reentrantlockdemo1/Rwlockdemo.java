package reentrantlockdemo1;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Rwlockdemo {

    static HashMap<String, Object> cachemap = new HashMap<>();
    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    static Lock read = rwlock.readLock();
    static Lock write = rwlock.writeLock();

    public static final Object get(String key) {
        System.out.println("read data: " + key);
        read.lock();
        try {
            return cachemap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object val) {
        write.lock();
        try {
           return cachemap.put(key, val);
        } finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
