package demoThreads.stringBuffer;

import demoThreads.fileWriter.SyncThread;

import java.util.concurrent.TimeUnit;

public class Main {
    static int counter;
    static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                    try {
                        synchronized (buffer) {
                            while (counter++ < 3){
                                buffer.append("A");
                                System.out.print(">" + counter + " ");
                                System.out.println(buffer);
                                TimeUnit.MILLISECONDS.sleep(500);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }.start();
        TimeUnit.MILLISECONDS.sleep(100);
        while (counter++ < 6) {
            System.out.print("<" + counter + " ");
            buffer.append("B");
            System.out.println(buffer);
        }
    }
}
