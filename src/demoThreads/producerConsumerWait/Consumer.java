package demoThreads.producerConsumerWait;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    Store store;
    int product = 0 ;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
