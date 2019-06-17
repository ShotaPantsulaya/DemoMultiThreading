package demoThreads.resourcePool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AudioChannel {
    private int channelId;

    public AudioChannel(int channelId) {
        super();
        this.channelId = channelId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void using() {
        try {
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
