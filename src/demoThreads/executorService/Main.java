package demoThreads.executorService;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Future<String>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 7; i++) {
            list.add(service.submit(new BaseCallable()));
        }
        service.shutdown();
        for (Future<String> future : list) {
            System.out.println(future.get() + " result fixed");
        }
    }
}
