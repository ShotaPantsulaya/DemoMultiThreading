package demoThreads.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountThread implements Runnable {
    CommonResource res;
    Semaphore sem;
    String name;
    CountThread(CommonResource res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }
    public void run() {
        try {
            System.out.println(name + " Waiting");
            sem.acquire();
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + ": " + res.x);
                res.x++;
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " free");
        sem.release();
    }
}
