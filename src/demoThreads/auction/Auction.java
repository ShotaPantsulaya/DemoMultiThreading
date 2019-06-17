package demoThreads.auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    private ArrayList<Bid> list;
    private CyclicBarrier barrier;
    private final int BIDS_NUMBER = 5;

    public Auction() {
        list = new ArrayList<>();
        barrier = new CyclicBarrier(this.BIDS_NUMBER, () -> {
            Bid winner = defineWinner();
            System.out.println("Bid #" + winner.getBidID() + ", price; " + winner.getPrice() + " has won!");
        });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean addBid(Bid bid) {
        return list.add(bid);
    }

    public Bid defineWinner() {
        return Collections.max(list, Comparator.comparingInt(Bid::getPrice));
    }
}
