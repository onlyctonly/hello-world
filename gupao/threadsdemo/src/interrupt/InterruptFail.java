package interrupt;

//https://zhuanlan.zhihu.com/p/45667127
//https://www.zhihu.com/question/41048032
public class InterruptFail {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Java技术栈线程被中断，程序退出。");
                    return;
                }

                try {
                    // sleep源码会复位interrupt status
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Java技术栈线程休眠被中断，程序退出。");
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
