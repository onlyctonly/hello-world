package conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionWait implements Runnable{
    Lock lock;
    Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("conditionwait start");
            try {
                condition.await(); //1。阻塞 2。释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("conditionwait stop");
        } finally {
            lock.unlock();
        }
    }
}
