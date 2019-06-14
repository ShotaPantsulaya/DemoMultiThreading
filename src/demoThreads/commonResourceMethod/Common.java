package demoThreads.commonResourceMethod;

import java.util.concurrent.TimeUnit;

public class Common {
    int x = 0;

    synchronized void increment(){
        x=1;
        for (int i = 1; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " value " + i);
            x++;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}
