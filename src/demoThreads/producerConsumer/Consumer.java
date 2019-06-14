package demoThreads.producerConsumer;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    Store store;
    int product = 0 ;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product<5){
                int i = store.get();
                if (i==1) {
                    product = product + i;
                    System.out.println("Got product from the store. Consumer has " + product);
                }
                    TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
