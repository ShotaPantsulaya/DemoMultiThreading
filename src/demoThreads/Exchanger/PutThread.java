package demoThreads.Exchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public PutThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        this.message = "Hello, World!";
    }

    @Override
    public void run() {
        try {
            message += " Message from put thread!";
            message = exchanger.exchange(message);
            System.out.println(Thread.currentThread().getName() + " got " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
