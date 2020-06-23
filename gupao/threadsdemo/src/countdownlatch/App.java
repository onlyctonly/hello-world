package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {

            int finalI = i;
            new Thread(()->{
                System.out.println("thread"+ finalI);
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
    }
}
