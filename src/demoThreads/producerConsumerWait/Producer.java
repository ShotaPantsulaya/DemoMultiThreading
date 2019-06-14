package demoThreads.producerConsumerWait;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    Store store;
    int product = 5;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
