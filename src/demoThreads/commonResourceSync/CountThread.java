package demoThreads.commonResourceSync;

import java.util.concurrent.TimeUnit;

public class CountThread implements Runnable {
    Common res;

    public CountThread(Common res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " res " + res.x);
                res.x++;
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
