package demoThreads.resourcePool;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<String> list = new LinkedList<String>(){
            {
                this.add("0");
                this.add("1");
                this.add("2");
                this.add("3");
                this.add("4");
            }
        };
        ChannelPool<String> pool = new ChannelPool<>(list);
        TimeUnit.SECONDS.sleep(2); //ЕСЛИ УБРАТЬ ТО В ВЫВОДЕ БУДЕТ null??? НЕ УСПЕВАЕТ ИНИЦИАЛИЗИРОВАТЬ pool а User уже берут значения???
        for (int i = 0; i < 20; i++) {
            new User(pool).start();
        }
    }


}
