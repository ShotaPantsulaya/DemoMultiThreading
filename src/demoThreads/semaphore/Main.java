package demoThreads.semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        CommonResource commonResource = new CommonResource();
        new Thread(new CountThread(commonResource, sem, "Thread 1")).start();
        new Thread(new CountThread(commonResource, sem, "Thread 2")).start();
        new Thread(new CountThread(commonResource, sem, "Thread 3")).start();
    }
}
