package demoThreads.resourcePool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class User extends Thread {
    private boolean reading = false;
    private ChannelPool<String> pool;

    public User(ChannelPool<String> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        String string = null;
        try {
            string = pool.getResource(500);
            reading = true;
            System.out.println("Channel client #"+Thread.currentThread().getName()+" took channel #"+string);
            TimeUnit.MILLISECONDS.sleep((((long) (Math.random() * 100))));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ResourceException e) {
            System.out.println("Client thread #" + Thread.currentThread().getName() + " lost ->" + e.getMessage());
        } finally {
            if(string != null) {
                reading = false;
                System.out.println("Channel client #" + Thread.currentThread().getName() + " : " + string + " released.");
                pool.returnResource(string);
            }
        }
    }

    public boolean isReading() {
        return reading;
    }
}
