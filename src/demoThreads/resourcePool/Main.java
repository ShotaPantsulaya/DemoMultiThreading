package demoThreads.resourcePool;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        LinkedList<AudioChannel> list = new LinkedList<AudioChannel>() {
            {
                this.add(new AudioChannel(771));
                this.add(new AudioChannel(883));
                this.add(new AudioChannel(550));
                this.add(new AudioChannel(337));
                this.add(new AudioChannel(442));
            }
        };
        ChannelPool<AudioChannel> pool = new ChannelPool<>(list);
        for (int i = 0; i < 20; i++) {
            new User(pool).start();
        }
    }

}
