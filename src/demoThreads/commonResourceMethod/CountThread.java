package demoThreads.commonResourceMethod;

import java.util.concurrent.TimeUnit;

public class CountThread implements Runnable {
    Common res;

    public CountThread(Common res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.increment();
    }
}
