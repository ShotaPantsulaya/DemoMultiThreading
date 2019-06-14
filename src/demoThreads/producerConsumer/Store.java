package demoThreads.producerConsumer;

public class Store {

    int counter = 0;
    final int N = 5;

    synchronized int put() {
        if(counter<=N){
            System.out.println("There are " + counter + " items in store");
            counter++;
            return 1;
        }
        return 0;
    }

    synchronized int get() {
        if(counter>0){
            System.out.println("Store has " + counter + " items");
            counter--;
            return 1;
        }
        return 0;
    }
}
