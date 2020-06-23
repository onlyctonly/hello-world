package interrupt;


public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (true) {
                System.out.println("test");

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("again");
                    return;
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
        System.out.println("main out");
    }
}
