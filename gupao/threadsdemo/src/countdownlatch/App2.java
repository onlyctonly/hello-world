package countdownlatch;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class App2 extends Thread{
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new App2().start();
        }
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ LocalDateTime.now() );
    }
}
