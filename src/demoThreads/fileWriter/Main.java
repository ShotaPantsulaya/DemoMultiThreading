package demoThreads.fileWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Resource s = null;
        try {
            s = new Resource("data.txt");
            SyncThread thread1 = new SyncThread("First", s);
            SyncThread thread2 = new SyncThread("Second", s);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}
