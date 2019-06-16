package demoThreads.philosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread {
    Semaphore sem;
    int num = 0;
    int id;

    public Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while(num<3){
                sem.acquire();
                System.out.println("Eating " + id);
                TimeUnit.MILLISECONDS.sleep(500);
                num++;
                System.out.println("Finished eating " + id);
                sem.release();
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
