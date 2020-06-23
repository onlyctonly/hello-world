package startrule;

public class Main {
    static int x =0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(x); //10
        });
        x=10;
        t1.start();
    }
}
