package demoThreads.disableThread;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main");
        ThreadToDisable threadToDisable = new ThreadToDisable();
        Thread myT = new Thread(threadToDisable, "ProThread");
        myT.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            threadToDisable.dis();
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
