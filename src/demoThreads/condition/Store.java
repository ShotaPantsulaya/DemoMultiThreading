package demoThreads.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    int counter = 0;
    ReentrantLock lock;
    Condition condition;

    public Store() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    synchronized void put() {
        lock.lock();
        try {
            while (counter >= 3){
                condition.await();
            }
            counter++;
            System.out.println("Put 1 product");
            System.out.println(counter);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    synchronized void get() {
        lock.lock();
        try {
            while (counter < 1){
                condition.await();
            }
            counter--;
            System.out.println("Got 1 product");
            System.out.println(counter);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
