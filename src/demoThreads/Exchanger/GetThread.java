package demoThreads.Exchanger;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public GetThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        this.message = "Hmmm";
    }

    @Override
    public void run() {
        try {
            message += " Message from GetThread";
            message = exchanger.exchange(message);
            System.out.println(Thread.currentThread().getName() + " got " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
