package conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionNotify implements Runnable {
    Lock lock;
    Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("condition notify start");
            condition.signal();
            System.out.println("condition notify end");
        } finally {
            lock.unlock();
        }
    }
}
