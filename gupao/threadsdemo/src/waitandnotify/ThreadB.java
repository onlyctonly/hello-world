package waitandnotify;

public class ThreadB extends Thread {
    Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("b started");
            lock.notify();
            System.out.println("b finished");
        }
    }
}
