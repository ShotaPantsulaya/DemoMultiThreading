package demoThreads.executorService;

import java.util.ArrayDeque;

public class ProductList {
    private static ArrayDeque<String> deque = new ArrayDeque<String>(){
        {
            this.add("Product 1");
            this.add("Product 2");
            this.add("Product 3");
            this.add("Product 4");
            this.add("Product 5");
        }
    };

    public static String getProduct() {
        return deque.poll();
    }
}
