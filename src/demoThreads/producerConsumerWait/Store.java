package demoThreads.producerConsumerWait;

public class Store {

    int counter = 0;

    synchronized void put() {
        while (counter >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println("Producer added ");
        System.out.println("There are " + counter);
        notifyAll();
    }

    synchronized void get() {
        while (counter < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println("Consumer got 1");
        System.out.println("There are " + counter);
        notifyAll();
    }
}
