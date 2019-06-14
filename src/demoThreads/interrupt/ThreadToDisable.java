package demoThreads.interrupt;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {

    public ThreadToDisable() {
    }

    @Override
    public void run() {
        System.out.println("Start");
        int counter = 1;
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Cycle " + counter);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                counter++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Work work");
    }
}
