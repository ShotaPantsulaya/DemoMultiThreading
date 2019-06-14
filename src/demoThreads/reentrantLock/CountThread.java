package demoThreads.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {

    Common res;
    ReentrantLock lock;

    public CountThread(Common res, ReentrantLock lock) {
        this.res = res;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " value " + res.x);
                res.x++;
                TimeUnit.MILLISECONDS.sleep(100);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
