package demoThreads.Exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String > exchanger = new Exchanger<>();
        for (int i = 1; i<= 3; i++) {
            Thread thread1 = new Thread(new GetThread(exchanger));
            Thread thread2 = new Thread(new PutThread(exchanger));
            thread1.start();
            thread2.start();
        }
    }
}
