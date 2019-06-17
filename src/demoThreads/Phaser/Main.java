package demoThreads.Phaser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Item[] goods = new Item[20];
        for (int i = 0; i < goods.length; i++) {
            goods[i] = new Item(i + 1);
        }
        List<Item> list = Arrays.asList(goods);
        Storage storageA = Storage.createStorage(list.size(), list);
        Storage storageB = Storage.createStorage(list.size());
        Phaser phaser = new Phaser();
        phaser.register();
        int currentPhase;
        Thread tr1 = new Thread(new Truck(phaser, "1",5, storageA, storageB));
        Thread tr2 = new Thread(new Truck(phaser, "2",6, storageA, storageB));
        Thread tr3 = new Thread(new Truck(phaser, "3",7, storageA, storageB));
        printGoods("Items in storage A", storageA);
        printGoods("Items in storage B", storageB);
        tr1.start();
        tr2.start();
        tr3.start();
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Loading has finished. Phase" + currentPhase);
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Trucks have arrived. Phase" + currentPhase);
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Truck have been unloaded. Phase" + currentPhase);
        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Phases are synchronized and finished");
        }
        printGoods("Items in storage A", storageA);
        printGoods("Items in storage B", storageB);
    }

    public static void printGoods(String title, Storage storage) {
        System.out.println(title);
        Iterator<Item> itemIterator = storage.iterator();
        while (itemIterator.hasNext()) {
            System.out.print(itemIterator.next().getRegistrationNumber() + " ");
        }
        System.out.println();
    }
}
