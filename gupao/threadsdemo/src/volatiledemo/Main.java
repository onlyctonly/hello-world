package volatiledemo;

public class Main {
//    if no volatile keyword, process will keep running
    private static volatile boolean isFinished = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            int i=0;
            while (!isFinished) {
                i++;
            }
        });

        t1.start();
        Thread.sleep(1000);
        isFinished=true;
    }
}
