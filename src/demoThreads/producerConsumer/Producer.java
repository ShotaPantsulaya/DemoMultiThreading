package demoThreads.producerConsumer;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    Store store;
    int product = 5;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product>0){
                int put = store.put();
                if (put==1) {
                    product = product - put;
                    System.out.println("Put product in the store. Producer got " + product);
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
