package demoThreads.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            if(isDaemon()){
                System.out.println("Daemon start");
                TimeUnit.SECONDS.sleep(1);
            }else {
                System.out.println("Not daemon");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(!isDaemon()){
                System.out.println("Simple thread end");
            }else {
                System.out.println("Daemon end");
            }
        }

    }
}
