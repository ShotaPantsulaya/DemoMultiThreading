package demoThreads.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Common com = new Common();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(com, lock), String.valueOf(i));
            t.start();
        }
    }
}
