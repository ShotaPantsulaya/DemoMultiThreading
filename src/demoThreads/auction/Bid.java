package demoThreads.auction;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Bid extends Thread {
    private Integer bidID;
    private int price;
    private CyclicBarrier barrier;

    public Bid(Integer bidID, int price, CyclicBarrier barrier) {
        this.bidID = bidID;
        this.price = price;
        this.barrier = barrier;
    }

    public Integer getBidID() {
        return bidID;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client " + bidID + " specifies a price ");
            TimeUnit.MILLISECONDS.sleep(3000);
            int delta = new Random().nextInt(50);
            price+=delta;
            System.out.println("Bid " + bidID + " : " + price);
            barrier.await();
            System.out.println("Continues to work...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
