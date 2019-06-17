package demoThreads.resourcePool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class User extends Thread {
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;
    public User (ChannelPool<AudioChannel> pool) {
        this.pool = pool;
    }
    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.getResource(500); // изменить на 100
            reading = true;
            System.out.println("Channel Client #" + this.getId()
                    + " took channel #" + channel.getChannelId());
            channel.using();
        } catch (ResourceException e) {
            System.out.println("Client #" + this.getId() + " lost ->"
                    + e.getMessage());
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Channel Client #" + this.getId() + " : "
                        + channel.getChannelId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }
    public boolean isReading() {
        return reading;
    }
}
