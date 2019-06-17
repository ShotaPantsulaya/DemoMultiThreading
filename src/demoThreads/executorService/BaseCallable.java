package demoThreads.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BaseCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String product = ProductList.getProduct();
        String res;
        if (product != null) {
            res = product + " done";
        }else {
            res = "productList is empty";
        }
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(res);
        return res;
    }
}
