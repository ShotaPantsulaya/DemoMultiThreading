package demoThreads.Phaser;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Truck implements Runnable {
    private Phaser phaser;
    private String number;
    private int capacity;
    private Storage storageFrom;
    private Storage storageTo;
    private Queue<Item> bodyStorage;

    public Truck(Phaser phaser, String number, int capacity, Storage storageFrom, Storage storageTo) {
        this.phaser = phaser;
        this.number = number;
        this.capacity = capacity;
        this.storageFrom = storageFrom;
        this.storageTo = storageTo;
        bodyStorage = new ArrayDeque<>(capacity);
        phaser.register();
    }

    @Override

    public void run() {
        loadTruck();
        phaser.arriveAndAwaitAdvance();
        goTruck();
        phaser.arriveAndAwaitAdvance();
        unloadTruck();
        phaser.arriveAndDeregister();
    }

    private void loadTruck() {
        for (int i = 0; i < capacity; i++) {
            Item g = storageFrom.getGood();
            if (g == null) {
                return;
            }
            bodyStorage.add(g);
            System.out.println("Truck #" + number + " has loaded the item #" + g.getRegistrationNumber());
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unloadTruck() {
        int size = bodyStorage.size();
        for (int i = 0; i < size; i++) {
            Item g = bodyStorage.poll();
            storageTo.setGood(g);
            System.out.println("Truck #" + number + " has unloaded the item #" + g.getRegistrationNumber());
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void goTruck() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random(100).nextInt(500));
            System.out.println("Truck #" + number + " moving");
            TimeUnit.MILLISECONDS.sleep(new Random(100).nextInt(1000));
            System.out.println("Truck #" + number + " has arrived");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
