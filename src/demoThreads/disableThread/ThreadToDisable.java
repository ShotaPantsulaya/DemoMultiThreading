package demoThreads.disableThread;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {

    boolean isAlive;

    void dis(){
        isAlive=false;
    }

    public ThreadToDisable() {
        isAlive=true;
    }

    @Override
    public void run() {
        System.out.println("Start");
        int counter = 1;
        while (isAlive){
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
