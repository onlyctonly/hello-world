package conditiondemo;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new ConditionWait(lock,condition)).start();
        new Thread(new ConditionNotify(lock,condition)).start();
    }
}
